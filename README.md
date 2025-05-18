# *Arkanoid OOP Game – Java*

This is an object-oriented implementation of the classic **Arkanoid** game written in Java.  
The game is built using modular components that represent core game elements such as blocks, balls, paddle, score system, collision detection, and game environment.

---

## 🎮 Features

- **Object-Oriented Design (OOP)**
- Paddle and ball movement with physics-based reflection
- Collision detection using geometric calculations
- Block removal and score tracking
- Listener mechanism for game events
- Sprite-based rendering loop

---

## 🧩 Main Components

### 🔹 Core Classes

- `Ass5Game`: Main game runner class that initializes and starts the game.
- `Game`: Initializes game objects, starts the animation loop, and runs gameplay logic.
- `GameEnvironment`: Manages all collidable objects and provides collision info.

### 🔹 Geometry

- `Point`: Represents a point in 2D space.
- `Line`: Used to detect intersections and define movement paths.
- `Rectangle`: Defines block shapes and collision bounding boxes.

### 🔹 Game Elements

- `Ball`: The moving ball in the game.
- `Block`: The destructible bricks or walls.
- `Paddle`: The player-controlled paddle.

### 🔹 Utilities

- `Velocity`: Describes speed and direction.
- `Counter`: Utility for counting lives, score, etc.
- `Methods`: Collection of helper functions.

### 🔹 Interfaces

- `Collidable`: Interface for collidable objects.
- `Sprite`: Interface for drawable/updatable objects.
- `HitNotifier`: For notifying listeners of hit events.
- `HitListener`: Reacts to hit notifications.

### 🔹 Listeners

- `ScoreTrackingListener`: Updates score on hit.
- `BlockRemover`: Removes block on hit.
- `BallRemover`: Removes ball when out of bounds.
- `HundredScoreListener`: Adds bonus points.

### 🔹 UI

- `SpriteCollection`: Holds and manages all sprites.
- `ScoreIndicator`: Displays the current score on screen.

---

## ▶️ How to Run

1. **Compile all Java files**:

    ```bash
    javac *.java
    ```

2. **Run the main class**:

    ```bash
    java Ass5Game
    ```

> ✅ Make sure your environment supports drawing (e.g., Java GUI or game framework).

---

## 📌 Notes

- The game uses a **listener pattern** to decouple event handling (e.g., score updates, block/ball removal).
- Designed with **modularity** and **clean OOP** principles for easy extension and maintenance.
