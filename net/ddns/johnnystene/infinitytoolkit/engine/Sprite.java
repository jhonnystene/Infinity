package net.ddns.johnnystene.infinitytoolkit.engine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite {
    public BufferedImage image;
    public int width;
    public int height;

    public Sprite(int w, int h, int t) {
        image = new BufferedImage(w, h, t);
        width = w;
        height = h;
    }

    public Sprite(String path) {
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream(path));
            width = image.getWidth();
            height = image.getHeight();
        } catch(Exception e) {
            System.out.println("Sprite load error! Can't load " + path);
            // Load in error sprite
            image = new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = image.createGraphics();
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, 0, 64, 64);
            graphics.setColor(Color.MAGENTA);
            graphics.fillRect(0, 0, 32, 32);
            graphics.fillRect(32, 32, 64, 64);
            graphics.dispose();

            // Set params to match
            width = 64;
            height = 64;
        }
    }

    public void resize(int w, int h) {
        image = ImageUtils.resize(image, w, h);
        width = w;
        height = h;
    }
}
