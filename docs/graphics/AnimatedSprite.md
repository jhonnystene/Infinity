# AnimatedSprite

Animated version of `Sprite`. This class extends `Sprite` and can be used in its place.

#### Loading an Animated Sprite

`AnimatedSprite`s are created with the`AnimatedSprite(String path)`constructor. `path` is a path to a directory filled with only images in the classpath. It is recommended to have the images in numerical order. (ie. `0.png`, `1.png`, etc.)



#### Setting the animation speed

Simply change `frameInterval`  to the amount of in-game frames (games run at 60FPS by default) for one animation frame.



#### Actually running the animation

Every frame, `update()` has to be called. If this isn't done, the animation will not be animated.



#### Resizing

Exactly the same as `Sprite`. This will also resize all frames to the specified size, so it works for mismatched size animations. Mismatched size animations are not, however, recommended.
