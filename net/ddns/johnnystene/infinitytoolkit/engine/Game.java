/*
 * Infinity Game Engine
 * Copyright (C) 2020 Johnny Stene
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 *
 * This is the "main" game class. It pretty much just handles multithreading - nothing else.
 */
 
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

	// For some reason it breaks if I don't print something. I didn't want to print "Waiting for render to finish" every frame,
	// so we print it nowhere.
    public void doNothing() {
        PrintStream fuck = System.out;
        System.setOut(new PrintStream(new OutputStream() {public void write(int b) {}}));
        System.out.println("Waiting for render to finish...");
        System.setOut(fuck);
    }

    public void run() {
        try {
            if(window == null) { // Shouldn't happen anymore
                System.out.println("ERROR! Only create Game with Game(String, int, int) constructor.");
            }
            while(true) {
                if(!window.finishedDrawing) { // Wait for the window to release the framebuffer before ticking again
                    doTick(); // Run the loop once
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

	// This should be overrided
    public void doTick() {
        System.out.println("Please override the doTick function in your Game class.");
    }
}
