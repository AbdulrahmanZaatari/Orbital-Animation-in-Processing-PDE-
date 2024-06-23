import java.awt.Color;
import java.util.*;

public class Orbiter {
  public enum Type {
    CIRCLE, SQUARE, TRIANGLE
  }

  private final double orbitRadius;
  private final Type type; 
  private final Color fillColor; 
  private double orbitAngle; 
  private double orbitSpeed;
  private Matrix position;
  private final List<Orbiter> children = new LinkedList<Orbiter>();
  private final Orbiter parent; 
  
  public Orbiter(Orbiter parent, double orbitRadius, double orbitAngle, double orbitSpeed, Type type, Color fillColor) {
    this.orbitRadius = orbitRadius; 
    this.orbitAngle = orbitAngle; 
    this.type = type;
    this.fillColor = fillColor; 
    this.parent = parent; 
    this.orbitSpeed = orbitSpeed; 
    this.position = Matrix.vectorH2D(orbitRadius, 0);
    if (parent != null) parent.children.add(this);
  }
  
  public Matrix getMatrix() {
    return this.position;
  }
  public Color getFillColor() {
    return fillColor;
  }
   public Type getType() {
    return type;
  }

  public List<Orbiter> getChildren() {
    return children;
  }

  public double getOrbitRadius() {
    return orbitRadius;
  }
  
 public void updatePosition(double timeDelta) {
  // Update the orbit angle based on the orbit speed
  this.orbitAngle += this.orbitSpeed * timeDelta;

  // Calculate the new position using matrix operations
  double radianAngle = Math.toRadians(this.orbitAngle);
  Matrix rotationMatrix = Matrix.rotationH2D(radianAngle);
  Matrix translationMatrix = Matrix.translationH2D(this.orbitRadius, 0);

  try {
    // Apply the transformation to the initial position (should be at the origin)
    Matrix newPosition = translationMatrix.dot(rotationMatrix);
    if (this.parent != null) {
      // Combine with parent's position if not root
      newPosition = this.parent.getMatrix().dot(newPosition);
    }
    this.position = newPosition;
  } catch (UndefinedMatrixOpException e) {
    System.err.println(e.getMessage());
  }
}


}
>>>>>>> 75d9f19235717286aab0453fdd98ccf95d7caf96
