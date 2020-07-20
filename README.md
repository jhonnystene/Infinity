# Infinity

The Infinity Engine is a 2D game engine designed to be easy to use. You only need a basic understanding of Java to get started- it handles many of the important parts of a game so you don't have to- things like collision, animations, and world management. Being written in Java, you can easily extend, modify, or replace anything you need to. It's released under the Lesser GPL, so the only code you have to publish is any modifications you've made to the engine itself- your game's code stays completely under your control. See `docs/getting-started.md` for information about getting started.

See `docs/getting-started.md` for more information.



## Including your game's resources

The engine is made to load from classpath - this gets rid of any issues with file paths and lets your game exist as a single .jar file. All you have to do is add a folder inside your source folder (the tutorials all use `res`, for "resource"). Then, when you need to include the resource, just pass `/(your resource folder name)/(your file path)` to whatever function needs it. This also works for directories, in the case of `AnimatedSprite`.
