package net.ddns.johnnystene.infinitytoolkit.engine.graphics.ui.style;

import java.awt.*;

public class ButtonStyle {
    // Text
    public TextStyle textStyleHover;
    public TextStyle textStyleRegular;
    public TextStyle textStylePressed;
    public boolean centerText;
    public boolean hasText;

    // Background
    public Color backColorHover;
    public Color backColorRegular;
    public Color backColorPressed;
    public boolean hasBackground;

    // Border
    public Color borderColorHover;
    public Color borderColorRegular;
    public Color borderColorPressed;
    public int borderThickness;
    public boolean hasBorder;

    // Size
    public int defaultWidth;
    public int defaultHeight;

    public ButtonStyle() {
        // Text
        textStyleHover = new TextStyle();
        textStyleRegular = new TextStyle();
        textStylePressed = new TextStyle();
        centerText = true;
        hasText = true;

        // Background
        backColorHover = new Color(171, 171, 171);
        backColorRegular = new Color(138, 138, 138);
        backColorPressed = new Color(100, 100, 100);
        hasBackground = true;

        // Border
        borderColorHover = new Color(100, 100, 100);
        borderColorRegular = new Color(71, 71, 71);
        borderColorPressed = new Color(0, 0, 0);
        borderThickness = 2;
        hasBorder = true;

        // Size
        defaultHeight = 50;
        defaultWidth = 150;
    }
}
