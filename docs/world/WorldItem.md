# WorldItem

This represents an item in the world.



#### Creating a WorldItem

There are a total of 7 constructors for `WorldItem`. They are as follows:



###### WorldItem(Sprite[] sprites)

This takes one argument - an array of 8 sprites.



###### WorldItem(String path)

This takes one argument - a path to a file to load as a `Sprite`.

**NOTE:** This will be removed in a future version!



###### WorldItem(String path, int sX, int sY)

This is the same as `WorldItem(String path)` but it lets you set the X and Y coordinates of the item.

**NOTE:** This will be removed in a future version!



###### WorldItem(String path, int sX, int sY, int hX, int hY, int hW, int hH)

This is the same as `WorldItem(String Path, int sX, int sY)` but it lets you set the hitbox size.



###### WorldItem(Sprite s)

This takes one argument - a `Sprite`.



###### WorldItem(Sprite s, int sX, int sY)

This is the same as `WorldItem(Sprite s)` but it lets you set the X and Y coordinates of the item.



###### WorldItem(int w, int h, Color color)

**NOTE:** This is meant for placeholders and will be removed in a future version!

`w` is the width of the item

`h` is the height of the item

`color` is the color of the item.



#### Static Vs Isometric

Static `WorldItem`s don't change their sprite automatically to face where they're moving. Isometric `WorldItem`s have 8 different sprites that change based on what direction they're moving in. You can change whether a WorldItem is static or isometric by changing the `isometricItem` variable to `true` or `false`



###### Isometric Directions

To make things easier, `WorldItem` has constants for all 8 directions. These are:

- `NE`

- `N`

- `NW`

- `W`

- `SW`

- `S`

- `SE`

- `E`



#### Resizing

Resizing is done the same as in `Sprite`, but calling it on the `WorldItem` will resize all isometric sprites.





#### Loading sprites after creation

Sprites can be loaded with one of two functions:



###### loadSprite(String path)

This replaces all sprites (including isometric ones!) with the image pointed to by `path`.



###### loadSprite(String path, int direction)

This replaces an isometric sprite (chosen by `direction`) with the image pointed to by `path`.





#### Collision

The fun part!



###### Layers and Masks

There are 3 collision layers. A `WorldItem` can exist on any one of these three, but by default, it only exists on the first one. Each `WorldItem` also has a collision *mask*, which decides what collision layers it should check for when moving. These can be set with the boolean arrays `collisionLayer` and `collisionMask`.



###### Custom Hitboxes

You can set a custom hitbox by changing the `hitboxX`, `hitboxY`, `hitboxWidth`, and `hitboxHeight` of the `WorldItem`. These are relative to the position (which is the top left of the `Sprite`).



###### Checking for Collision

Checking for collision with another `WorldItem` is very simple. You need to call the `collidingWith(WorldItem item)` function, it will return `true` or `false` depending on whether or not the two items are colliding.



###### Moving with Collision

Moving while colliding is very simple. You need to call the `moveAndCollide(float moveX, float moveY, ArrayList<WorldItem> collisionItemLayer)` function. It is recommended to pass your `World`s default item list, `items`.
