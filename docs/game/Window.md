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

#### Checking if the mouse is inside an area

`Window` has an additional `mouseIn(int x, int y, int w, int h)` function that returns `true` if the mouse is in the given rectangle.

#### Checking if the mouse is down inside an area

`Window` has an additional `mouseStatus(int x, int y, int w, int h)` function that returns `2` if the mouse is clicked in the given rectangle, `1` if the mouse is in the given rectangle (but not down), or `0` if the mouse is not inside the given rectangle.

## The UI toolkit

`Window` has different functions for drawing UI objects.

**NOTE**: The UI toolkit will soon be replaced!

#### Missing features

The UI toolkit is missing the following features:

- Drawing images

- Button borders

- Global styling

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

#### Drawing Text

`Window` has 4 different functions for drawing text.

###### UIDrawString(int x, int y, int size, String string)

This function draws text, with (X, Y) being the top-left corner.

`x` is the X position.

`y` is the Y position.

`size` is the font size.

`string` is the text to draw.

###### UIDrawString(int x, int y, int size, String string, Color color)

This function draws text, with (X, Y) being the top-left corner.

`x` is the X position.

`y` is the Y position.

`size` is the font size.

`string` is the text to draw.

`color` is the color to draw the text as.

###### UIDrawCenteredString(int x, int y, int size, String string)

This function draws text, with (X, Y) being the center.

`x` is the X position.

`y` is the Y position.

`size` is the font size.

`string` is the text to draw.

###### UIDrawCenteredString(int x, int y, int size, String string, Color color)

This function draws text, with (X, Y) being the center.

`x` is the X position.

`y` is the Y position.

`size` is the font size.

`string` is the text to draw.

`color` is the color to draw the text as.

#### Buttons

`Window` has 1 function to handle buttons.

###### UIDrawButton(Button button, int x, int y)

This function draws a `Button` at the given X and Y coordinates. It returns `true` if the button is pressed, and `false` if the button is not pressed.
