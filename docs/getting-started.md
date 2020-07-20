# Getting Started

This will help you get up and running with the Infinity engine.

#### Including the engine in your game

This depends a bit on your setup - you may need to do a bit of research if it isn't listed here.

###### Eclipse/IntelliJ IDEA

Simply drag the `net` folder into the source folder for your project (it's probably named `src`). Your IDE will take care of the rest.



#### Creating your first game

Your main class should extend the `Game` class. This should also be where you put your `public static void main(String[] args)` block. Inside, you should create a new instance of your main class. Inside the main class, you should have a constructer that calls `super()` with your desired window title and size. This is where you should also put any initialization code - preloading sprites, sounds, etc. You should also have a `public void doTick()` function overriding the default - this is where your game loop should be stored. Here's an example with a main class called `MyGame`:

```java
public class MyGame extends Game {
    public MyGame() {
        super("My Game", 800, 600);
    }

    @Override
    public void doTick() {
        System.out.println("Tick!");
    }

    public static void main(String[] args) {
        MyGame myGame = new MyGame();
        myGame.start();
    }
}
```

This creates a blank, 800x600 window with the title "My Game" that prints "Tick!" to the console on every frame.



#### Including your resources in your game

Infinity loads all files from the classpath. This makes sure there are no issues with file locations, and lets you distribute your game as just the .jar file. It is recommended to name your resource file `res` but it isn't required. Everywhere the engine needs a file path, just type in the absolute path to your file. For example, if you have your resources in `res`, and inside there you have a folder called `player` and inside that, an image called `idle.png`, you would pass `/res/player/idle.png`.
