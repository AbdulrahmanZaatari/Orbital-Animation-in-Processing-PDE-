/**
 * A simple m x n matrix class.
 *
 * @Abdulrahman Al Zaatari
 * @version Sept. 2017
 */

 public class Matrix {
  private int m, n;
  private double[][] M;
  
  public Matrix(double[][] array) {
    M = array;
    m = array.length; 
    n = array[0].length; 
  }
  
  public int nCols() {
    return n;
  }
  
  public int nRows() {
    return m;
  }
  
  public double entry(int i, int j) { 
    return M[i][j];
  }
  
  public Matrix dot(Matrix that) throws UndefinedMatrixOpException {
    if (this.nCols() != that.nRows()) {
      throw new UndefinedMatrixOpException("Matrix dimensions do not match for multiplication.", this, that);
    }
    double[][] result = new double[this.m][that.nCols()];
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < that.nCols(); j++) {
        for (int k = 0; k < this.nCols(); k++) {
          result[i][j] += this.M[i][k] * that.M[k][j];
        }
      }
    }
    return new Matrix(result);
  }
  
  public Matrix plus(Matrix that) throws UndefinedMatrixOpException {
    if (this.nRows() != that.nRows() || this.nCols() != that.nCols()) {
      throw new UndefinedMatrixOpException("Matrices dimensions do not match for addition.", this, that);
    }
    double[][] sum = new double[this.m][this.n];
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        sum[i][j] = this.M[i][j] + that.M[i][j];
      }
    }
    return new Matrix(sum);
  }

  public static Matrix translationH2D(double tx, double ty) {
    double[][] trans = {{1, 0, tx}, {0, 1, ty}, {0, 0, 1}};
    return new Matrix(trans);
  }

  public static Matrix vectorH2D(double x, double y) {
    double[][] vector = {{x}, {y}, {1}};
    return new Matrix(vector);
  }
  public static Matrix rotationH2D(double theta) {
        double[][] rotationMatrix = {
            {Math.cos(theta), -Math.sin(theta), 0},
            {Math.sin(theta), Math.cos(theta), 0},
            {0, 0, 1}
        };
        return new Matrix(rotationMatrix);
    }

        

  public static Matrix identity(int n) {
    double[][] ident = new double[n][n];
    for (int i = 0; i < n; i++) {
      ident[i][i] = 1;
    }
    return new Matrix(ident);
  }

  public static Matrix identity(int m, int n) {
    double[][] ident = new double[m][n];
    for (int i = 0; i < Math.min(m, n); i++) {
      ident[i][i] = 1;
    }
    return new Matrix(ident);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(M[i][j] + " ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}
