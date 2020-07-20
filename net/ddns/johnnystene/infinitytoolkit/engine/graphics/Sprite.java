/*
 * Infinity Game Engine
 * Copyright (C) 2020 Johnny Stene

 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA

 */
 
package net.ddns.johnnystene.infinitytoolkit.engine.graphics;

import net.ddns.johnnystene.infinitytoolkit.engine.utilities.ImageUtils;

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
