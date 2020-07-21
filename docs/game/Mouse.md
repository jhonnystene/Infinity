# Mouse

The `Mouse` class handles mouse inputs for `Window`.

#### Variable List

`x` - X position of the mouse cursor

`y` - Y position of the mouse cursor

`down` - Whether or not any mouse button is down

#### Function List

`inArea(int x, int y, int w, int h)` - Whether or not the mouse cursor is in a rectangular area

`areaStatus(int x, int y, int w, int h)` - Returns 2 if mouse button clicked in the area



#### Checking if the mouse is inside an area

`Window` has an additional `mouseIn(int x, int y, int w, int h)` function that returns `true` if the mouse is in the given rectangle.

#### Checking if the mouse is down inside an area

`Window` has an additional `mouseStatus(int x, int y, int w, int h)` function that returns `2` if the mouse is clicked in the given rectangle, `1` if the mouse is in the given rectangle (but not down), or `0` if the mouse is not inside the given rectangle.
