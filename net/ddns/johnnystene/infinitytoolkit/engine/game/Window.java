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
 
package net.ddns.johnnystene.infinitytoolkit.engine.game;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import net.ddns.johnnystene.infinitytoolkit.engine.graphics.Sprite;
import net.ddns.johnnystene.infinitytoolkit.engine.graphics.ui.Button;
import net.ddns.johnnystene.infinitytoolkit.engine.graphics.ui.Label;
import net.ddns.johnnystene.infinitytoolkit.engine.graphics.ui.style.TextStyle;
import net.ddns.johnnystene.infinitytoolkit.engine.world.WorldItem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Window extends JFrame {
    private JComponent drawSurface;
    private BufferedImage frameBuffer;

    public Keyboard keyboard;
    public Mouse mouse;
    public Camera camera;

    public int width = 0;
    public int height = 0;

    public boolean finishedDrawing = false;

    public Window(String title, int w, int h) {
        width = w;
        height = h;
        frameBuffer = new BufferedImage(width, height, 1); // Initialize the framebuffer
        drawSurface = new JComponent() { // Create a custom JComponent to draw on
            @Override
            public void paintComponent(Graphics g) {
                if(finishedDrawing) {
                    super.paintComponent(g);
                    g.drawImage(frameBuffer, 0, 0, this);
                    finishedDrawing = false;
                }
            }
        };
        drawSurface.setDoubleBuffered(true);

        // For some reason JFrame can't just, y'know, handle its own input
        keyboard = new Keyboard();
        mouse = new Mouse();
        camera = new Camera();
        addKeyListener(keyboard);
        drawSurface.addMouseListener(mouse);
        drawSurface.addMouseMotionListener(mouse);

        setTitle(title);
        setPreferredSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(drawSurface);
        pack();
        setVisible(true);

        // This is fucking retarded. Thanks, Oracle.
        ActionListener screenRefresher = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        drawSurface.repaint();
                    }
                });
            }
        };
        new Timer(16, screenRefresher).start();
    }

    public Graphics2D createGraphics() {
        return frameBuffer.createGraphics();
    }

    public void centerCamera(WorldItem item) {
        camera.x = (int) item.x - ((width / 2) - (item.width / 2));
        camera.y = (int) item.y - ((height / 2) - (item.height / 2));

        if(camera.x < 0) camera.x = 0;
        if(camera.y < 0) camera.y = 0;
        if(camera.x + width > 10240) camera.x = 10240 - width;
        if(camera.y + height > 10240) camera.y = 10240 - height;
    }

    public boolean mouseIn(int x, int y, int w, int h) {
        if(mouse.x > x && mouse.x < x + w && mouse.y > y && mouse.y < y + h)
            return true;

        return false;
    }

    public int mouseStatus(int x, int y, int w, int h) {
        if(mouseIn(x, y, w, h)) {
            if(mouse.down) return 2;
            else return 1;
        } else return 0;
    }

    // UIToolkit 3.0
    private void drawText(String text, Color color, Font font, boolean antiAlias, int x, int y) {
        Graphics2D graphics = frameBuffer.createGraphics();
        graphics.setColor(color);
        if(antiAlias) graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setFont(font);
        FontMetrics metrics = graphics.getFontMetrics(font);
        int height = metrics.getHeight();
        graphics.drawString(text, x, y + height); // Java!
        graphics.dispose();
    }

    // Todo: Java's text height getting sucks ass.
    private void drawCenteredText(String text, Color color, Font font, boolean antiAlias, int x, int y) {
        Graphics2D graphics = frameBuffer.createGraphics();
        graphics.setColor(color);
        if(antiAlias) graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        FontMetrics metrics = graphics.getFontMetrics(font);
        int width = metrics.stringWidth(text);
        int height = metrics.getHeight();
        x = x - (width / 2);
        y = y + (height / 4);
        graphics.setFont(font);
        graphics.drawString(text, x, y);
        graphics.dispose();
    }

    public boolean UIDrawButton(Button button, int x, int y) {
        Graphics2D graphics = frameBuffer.createGraphics();
        int drawType = mouseStatus(x, y, button.width, button.height);

        // Draw background
        if(button.style.hasBackground) {
            if (drawType == 0) graphics.setColor(button.style.backColorRegular);
            else if (drawType == 1) graphics.setColor(button.style.backColorHover);
            else if (drawType == 2) graphics.setColor(button.style.backColorPressed);
            graphics.fillRect(x, y, button.width, button.height);
        }

        // Draw border
        if(button.style.hasBorder) {
            if (drawType == 0) graphics.setColor(button.style.borderColorRegular);
            else if (drawType == 1) graphics.setColor(button.style.borderColorHover);
            else if (drawType == 2) graphics.setColor(button.style.borderColorPressed);
            graphics.fillRect(x, y, button.width, button.style.borderThickness);
            graphics.fillRect(x, y + button.height - button.style.borderThickness, button.width, button.style.borderThickness);
            graphics.fillRect(x, y, button.style.borderThickness, button.height);
            graphics.fillRect(x + button.width - button.style.borderThickness, y, button.style.borderThickness, button.height);
        }

        // Draw text
        if(button.style.hasText) {
            TextStyle textStyle = null;
            if(drawType == 0) textStyle = button.style.textStyleRegular;
            else if(drawType == 1) textStyle = button.style.textStyleHover;
            else if(drawType == 2) textStyle = button.style.textStylePressed;
            if(button.style.centerText) {
                drawCenteredText(button.text, textStyle.color, textStyle.font, textStyle.antiAlias, x + (button.width / 2), y + (button.height / 2));
            } else {
                drawText(button.text, textStyle.color, textStyle.font, textStyle.antiAlias, x, y);
            }
        }

        graphics.dispose();
        if(drawType == 2) return true;
        return false;
    }

    public void UIDrawLabel(Label label, int x, int y) {
        if(label.centered) {
            drawCenteredText(label.text, label.style.color, label.style.font, label.style.antiAlias, x, y);
        } else {
            drawText(label.text, label.style.color, label.style.font, label.style.antiAlias, x, y);
        }
    }

    public void UIDrawSprite(Sprite sprite, int x, int y) {
        Graphics2D graphics = frameBuffer.createGraphics();
        graphics.drawImage(sprite.image, x, y, this);
        graphics.dispose();
    }

    // UIToolkit 2.0 TODO: Remove Me
    public int UIDrawRect(int x, int y, int w, int h, Color color) {
        Graphics2D graphics = frameBuffer.createGraphics();
        graphics.setColor(color);
        graphics.drawRect(x, y, w, h);
        graphics.dispose();
        return mouseStatus(x, y, w, h);
    }

    public int UIDrawRect(int x, int y, int w, int h, Color color, Color hoverColor) {
        Graphics2D graphics = frameBuffer.createGraphics();
        if(mouseStatus(x, y, w, h) == 1) {
            graphics.setColor(hoverColor);
        } else graphics.setColor(color);
        graphics.drawRect(x, y, w, h);
        graphics.dispose();

        return mouseStatus(x, y, w, h);
    }

    public int UIDrawFilledRect(int x, int y, int w, int h, Color color) {
        Graphics2D graphics = frameBuffer.createGraphics();
        graphics.setColor(color);
        graphics.fillRect(x, y, w, h);
        graphics.dispose();
        return mouseStatus(x, y, w, h);
    }

    public int UIDrawFilledRect(int x, int y, int w, int h, Color color, Color hoverColor) {
        Graphics2D graphics = frameBuffer.createGraphics();
        if(mouseStatus(x, y, w, h) == 1) {
            graphics.setColor(hoverColor);
        } else graphics.setColor(color);
        graphics.fillRect(x, y, w, h);
        graphics.dispose();

        return mouseStatus(x, y, w, h);
    }
}
