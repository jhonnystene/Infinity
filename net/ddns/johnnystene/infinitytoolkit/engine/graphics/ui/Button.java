package net.ddns.johnnystene.infinitytoolkit.engine.graphics.ui;

import net.ddns.johnnystene.infinitytoolkit.engine.graphics.ui.style.ButtonStyle;

public class Button {
    public ButtonStyle style;
    public String text;
    public int width;
    public int height;

    public Button(String t) {
        text = t;
        style = new ButtonStyle();
        width = style.defaultWidth;
        height = style.defaultHeight;
    }

    public Button(String t, ButtonStyle s) {
        text = t;
        style = s;
        width = style.defaultWidth;
        height = style.defaultHeight;
    }

    public Button(String t, ButtonStyle s, int w, int h) {
        text = t;
        style = s;
        width = w;
        height = h;
    }
}
