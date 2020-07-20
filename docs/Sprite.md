# Sprite

`Sprite` can load and store an image, for use in a `WorldItem`.

#### Loading a sprite

`Sprite`s are created with the `Sprite(String path)` constructor. `path` is a path to an image in the classpath.

#### Changing a sprite's image

`Sprite`s are stored in a `BufferedImage` called `image` that can be replaced. Be sure to update `width` and `height` to make sure other classes play nice.

#### Resizing a sprite

`Sprite`s can be resized by calling the `resize(int w, int h)` function. This will resize the sprite and adjust the `width` and `height` variables.
