package net.ddns.johnnystene.infinitytoolkit.engine;

import net.ddns.johnnystene.infinitytoolkit.engine.ImageUtils;

import java.awt.image.BufferedImage;

public class InventoryItem {
    public String name;
    public BufferedImage image;
    public int id;

    public boolean inWorld = false;
    public int x = 0;
    public int y = 0;
    public int width = 64;
    public int height = 64;

    public InventoryItem(String n, BufferedImage i, int itemId) {
        name = n;
        id = itemId;
        image = ImageUtils.resize(i, 64, 64);
    }

    public InventoryItem(String n, BufferedImage i, int itemId, int px, int py) {
        name = n;
        id = itemId;
        image = ImageUtils.resize(i, 64, 64);
        x = px;
        y = py;
        inWorld = true;
    }

}
