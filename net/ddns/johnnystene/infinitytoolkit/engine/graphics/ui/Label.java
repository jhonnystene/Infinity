package net.ddns.johnnystene.infinitytoolkit.engine.graphics.ui;

import net.ddns.johnnystene.infinitytoolkit.engine.graphics.ui.style.TextStyle;

public class Label {
    public TextStyle style;
    public String text;

    public Label(String t) {
        text = t;
        style = new TextStyle();
    }

    public Label(String t, TextStyle s) {
        text = t;
        style = s;
    }
}
