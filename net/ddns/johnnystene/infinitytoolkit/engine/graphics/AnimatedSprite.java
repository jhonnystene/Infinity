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
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AnimatedSprite extends Sprite {
    public ArrayList<BufferedImage> frames;
    public int currentFrame = 0;
    public int frameInterval = 1;
    public int frameCounter = 0;

    public AnimatedSprite(String path) {
        super(1, 1, BufferedImage.TYPE_INT_RGB);
        frames = new ArrayList<>();

        // Load all files from directory
        ArrayList<String> filenames = new ArrayList<>();

        try {
            InputStream in = this.getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String resource;

            while ((resource = br.readLine()) != null) {
                filenames.add(path + "/" + resource);
            }
        } catch(Exception e) {
            System.out.println("Couldn't read directory: " + path);
        }

        for(String filename : filenames) {
            try {
                BufferedImage temp = ImageIO.read(this.getClass().getResourceAsStream(filename));
                frames.add(temp);
            } catch(Exception e) {
                System.out.println("Failed to load frame: " + filename);
            }
        }

        width = frames.get(0).getWidth();
        height = frames.get(0).getHeight();
        image = frames.get(0);
    }

    public void update() {
        frameCounter ++;
        if(frameCounter % frameInterval == 0) {
            if(currentFrame == frames.size() - 1) {
                currentFrame = 0;
            } else currentFrame ++;
        }

        image = frames.get(currentFrame);
    }

    public void resize(int w, int h) {
        for(int i = 0; i < frames.size(); i ++) {
            frames.set(i, ImageUtils.resize(frames.get(i), w, h));
        }
        width = w;
        height = h;
        update();
    }
}
