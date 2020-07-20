# Infinity

A 2D game engine written in Java.

## Introduction

The Infinity Engine is a game engine designed to be easy to use. You only need a basic understanding of Java to get started- it handles many of the important parts of a game so you don't have to- things like collision, animations, and world management. Being written in Java, you can easily extend, modify, or replace anything you need to. It's released under the Lesser GPL, so the only code you have to publish is any modifications you've made to the engine itself- your game's code stays completely under your control.

## Including in your game

This is very easy. If you're using Eclipse or IntelliJ (which you really should be!) you just need to drag the "net" folder into the source folder for your game and import whatever packages you need.

Your main class should extend the `Game` class. This should also be where you put your `public static void main(String[] args)` block. Inside, you should create a new instance of your main class. Inside the main class, you should have a constructer that calls `super()` with your desired window title and size. This is where you should also put any initialization code - preloading sprites, sounds, etc. You should also have a `public void doTick()` function overriding the default - this is where your game loop should be stored. At the end of `doTick()`, you need to put `window.finishedDrawing = true;` to tell the renderer that the frame is ready. Here's an example with a main class called `MyGame`:

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

## Including your game's resources

The engine is made to load from classpath - this gets rid of any issues with file paths and lets your game exist as a single .jar file. All you have to do is add a folder inside your source folder (the tutorials all use `res`, for "resource"). Then, when you need to include the resource, just pass `/(your resource folder name)/(your file path)` to whatever function needs it. This also works for directories, in the case of `AnimatedSprite`.
