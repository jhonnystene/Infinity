# Version 1.1b - The UI Update

Previously, the UI framework was kind of a mess. Elements would disappear when clicked, the code you had to type to draw them was so long it went offscreen but still didn't even provide a decent amount of style options, text never rendered in the right place, the list goes on. This update changes all of that with a new and improved UI framework.

#### Better code organization

Previously, all of the engine's code was in one folder, which made it hard to find what you're looking for in the list of files. Now, all needed files are in seperate folders, like "graphics" and "utilities".

#### Class-based, rather than function-based

Before, UI elements had to be drawn by passing every bit of the style into one function. This makes the code hard to read and modify. This was fixed by introducing classes for UI objects - now you pass 3 arguments and your items get drawn how you want, every time.

#### Common Styles

One thing I found was that when I wanted to, for example, make two buttons look similar, there was a lot of copy/paste for colors, sizes, etc. This is no more! Now, you can define a style once and use it across many objects. There are different style types for each kind of UI element and you can define as many as you need, switch through them, or modify them on the fly.

#### Easier image drawing

Previously, when you wanted to draw an image to the screen, you needed to grab a `Graphics2D` for the framebuffer and draw it manually. That was dumb. Now, you can just pass a `Sprite` to one function. Easy!

#### Mouse functions make more sense

The functions for checking if the mouse was in, or clicked in, an area were not in the `Mouse` class. This makes no sense to me, so I moved it to the `Mouse` class.
