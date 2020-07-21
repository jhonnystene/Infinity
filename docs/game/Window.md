# The Window class

A `Window` instance is created alongside `Game`. It is named `window`.

## The Camera

`Window` has a `Camera` named `camera` that is publicly accessible. It stores the X and Y position of the in-game camera, and is used by some drawing functions to decide where to draw objects.

#### Centering the Camera

Centering the Camera on an object can be done by calling the `Window.centerCamera(WorldItem item)` function.

## Custom Drawing

You can call `Window.createGraphics()` to get a `Graphics2D` object of the window framebuffer.

## The Keyboard

The `Window` has a default `Keyboard` called `keybord`. It is set up to handle key events for the `Window` automatically.

## The Mouse

The `Window` has a default `Mouse` called `mouse`. It is set up to handle mouse events for the `Window` automatically.

# 

## UI Function List

For more information on creating and using the various UI elements, see their respective documentation.

`drawButton(Button button, int x, int y)` - Draws a `Button` to the screen. Returns `true` if the button is pressed.

`drawLabel(Label label, int x, int y)` - Draws a `Label` to the screen

`drawSprite(Sprite sprite, int x, int y)` - Draws a `Sprite` to the screen

#### Missing features

The UI toolkit is missing the following features:

- Drawing circles

#### Drawing Rectangles

`Window` has 3 different functions for drawing rectangles.

###### UIDrawRect(int x, int y, int w, int h, Color color)

This function draws the outline of a rectangle.

`x` is the X position.

`y` is the Y position.

`w` is the width.

`h` is the height.

`color` is the `Color` the rectangle should be drawn in.

This function returns the `mouseStatus` for the rectangle.

###### UIDrawRect(int x, int y, int w, int h, Color color, Color hoverColor)

This function draws the outline of a rectangle.

`x` is the X position.

`y` is the Y position.

`w` is the width.

`h` is the height.

`color` is the `Color` the rectangle should be drawn in.

`hoverColor` is the `Color` the rectangle should be drawn in when the mouse is over it.

This function returns the `mouseStatus` for the rectangle.

###### UIDrawFilledRect(int x, int y, int w, int h, Color color)

This function draws a filled-in rectangle.

`x` is the X position.

`y` is the Y position.

`w` is the width.

`h` is the height.

`color` is the `Color` the rectangle should be drawn in.

This function returns the `mouseStatus` for the rectangle.

###### UIDrawFilledRect(int x, int y, int w, int h, Color color, Color hoverColor)

This function draws a filled-in rectangle.

`x` is the X position.

`y` is the Y position.

`w` is the width.

`h` is the height.

`color` is the `Color` the rectangle should be drawn in.

`hoverColor` is the `Color` the rectangle should be drawn in when the mouse is over it.

This function returns the `mouseStatus` for the rectangle.
