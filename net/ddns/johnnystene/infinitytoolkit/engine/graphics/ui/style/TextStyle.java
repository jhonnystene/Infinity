package net.ddns.johnnystene.infinitytoolkit.engine.graphics.ui.style;

import java.awt.Color;
import java.awt.Font;

public class TextStyle {
    public Color color;
    public int size;
    public boolean antiAlias;
    public Font font;

    public TextStyle() {
        color = new Color(0, 0, 0);
        size = 12;
        antiAlias = true;
        font = new Font("Sans Serif", Font.PLAIN, size);
    }

    public void refreshFont() {
        font = new Font("Sans Serif", Font.PLAIN, size);
    }
}
