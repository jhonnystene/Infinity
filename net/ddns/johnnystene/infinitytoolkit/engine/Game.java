package net.ddns.johnnystene.infinitytoolkit.engine;

import java.io.OutputStream;
import java.io.PrintStream;

public class Game extends Thread {
    public Window window;
    public String title;
    public int width;
    public int height;

    public Game(String t, int w, int h) {
        super();
        title = t;
        width = w;
        height = h;
        window = new Window(title, width, height);
    }

    public void doNothing() {
        PrintStream fuck = System.out;
        System.setOut(new PrintStream(new OutputStream() {public void write(int b) {}}));
        System.out.println("Waiting for render to finish...");
        System.setOut(fuck);
    }

    public void run() {
        try {
            if(window == null) {
                System.out.println("ERROR! Only create Game with Game(String, int, int) constructor.");
            }
            while(true) {
                if(!window.finishedDrawing) { // Wait for the window to release the framebuffer before ticking again
                    doTick();
                    window.finishedDrawing = true;
                } else {
                    doNothing();
                }
            }
        } catch(Exception e) {
            System.out.println("FATAL: Error in game loop: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void doTick() {
        System.out.println("Please override the doTick function in your Game class.");
    }
}
