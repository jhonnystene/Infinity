# World

The actual game world.



#### Creating the World

There are two constructors for `World`:



###### World()

This creates a blank, 4096x4096 world.



###### World(String path)

This creates a 4096x4096 world with the file pointed to by `path`.



#### Managing items

`World` has an `ArrayList<WorldItem>` called `items` that you can add your items to. Anything inside `items` will be rendered with the rest of the world.



#### Rendering

`World` has two methods for rendering the world.



###### renderTo(Graphics2D graphics, boolean debug)

This takes a `Graphics2D` object (it's best to use the `window.createGraphics()` in your `Game` class) and a boolean. The boolean tells whether or not to draw the hitboxes and sprite bounds on screen.

**NOTE:** This will be removed in a future version!



###### renderTo(Graphics2D graphics, int viewportX, int viewportY, int viewportW, int viewportH, boolean debug)

This is the same as `renderTo(Graphics2D graphics, boolean debug)` but it also has variables for the viewport X, Y, Width, and Height. It is recommended to pass the `x` and `y` variables for your `Window`'s `Camera`. The `viewportW` and `viewportH` are unused.



**NOTE:** This will be removed in a future version!
