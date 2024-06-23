Orbital Animation in Processing (PDE)

This project demonstrates an orbital animation system implemented in Processing (PDE). The animation features a hierarchical structure of orbiters, where each orbiter can have its own set of child orbiters, creating a dynamic and visually engaging simulation of planetary-like movements.

 Project Structure:

- Main PDE File: Contains the setup and draw functions for initializing and rendering the animation.
- Orbiter Class: Manages individual orbiters, including their properties, position updates, and drawing methods.
- Matrix Class: Handles matrix operations for position calculations.
- UndefinedMatrixOpException Class: Custom exception for handling undefined matrix operations.
- sketch.properties: Contains configuration settings for the Processing sketch.

 Features:

- Multiple Scenes: Two pre-defined scenes with different parameters to showcase various configurations.
- Hierarchical Structure: Each orbiter can have child orbiters, allowing for complex orbital systems.
- Configurable Speed: The animation speed can be adjusted via a speedModifier parameter.
- Shape Variety: Orbiters can be rendered as circles, squares, or triangles.

 Setup and Usage:

1. Clone the Repository:
   sh
   git clone https://github.com/AbdulrahmanZaatari/Orbital-Animation.git
   cd Orbital-Animation
   

2. Open in Processing:
   - Open the .pde file in the Processing IDE.

3. Run the Animation:
   - Click the play button in the Processing IDE to start the animation.
   - Toggle between different scenes by uncommenting the respective setupScene function in the setup() method.

4. Customize:
   - Modify parameters such as speedModifier and clearBackground to achieve different effects.
   - Add or remove orbiters in the setupScene methods to create new orbital configurations.

 Example Scene 1

java
void setupScene1() {
  sun = new Orbiter(null, 0, 0, 0, Orbiter.Type.CIRCLE, Color.yellow); 
  Orbiter earth = new Orbiter(sun, 50, 0, 1, Orbiter.Type.CIRCLE, Color.blue);
  Orbiter moon = new Orbiter(earth, 30, 0, 1, Orbiter.Type.CIRCLE, Color.gray);
  //Additional orbiters...
}


 Example Scene 2

java
void setupScene2() {
  speedModifier = 0.25;
  sun = new Orbiter(null, 0, 0, 0, Orbiter.Type.TRIANGLE, Color.yellow); 
  Orbiter earth = new Orbiter(sun, 50, 0, 10, Orbiter.Type.TRIANGLE, Color.blue);
  //Additional orbiters...
}

 Contributing

Contributions are welcome! Feel free to open issues or submit pull requests for enhancements and bug fixes.

 License

This project is licensed under the MIT License.

---

Feel free to modify this description according to your preferences or add any additional details that you find necessary.