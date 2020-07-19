package net.ddns.johnnystene.infinitytoolkit.engine;

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
