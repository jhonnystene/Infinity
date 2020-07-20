# TextStyle

Holds style information for text.



#### Font Size

The default font size is 12, but can be changed by modifying the `size` variable. Please note that this requires a font refresh.



#### Anti-Aliasing

Anti-Aliasing is enabled by default, but can be disabled by modifying the `antiAliasing` variable. This does not require a font refresh.



#### Color

By default, the font color is black, but this can be changed by modifying the `color` variable. This does not require a font refresh.



#### Refreshing font

To apply some changes to a `TextStyle`, you need to refresh the font by calling `refreshFont()`.
