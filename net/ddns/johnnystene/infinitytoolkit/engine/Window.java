package net.ddns.johnnystene.infinitytoolkit.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
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

    public void renderWorld(World world) {
        Graphics2D graphics = frameBuffer.createGraphics();
        for(WorldItem item : world.items) {
            graphics.drawImage(item.sprite.image, (int) item.x - camera.x, (int) item.y - camera.y, this);
        }
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

    // UI Framework
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

    public int UIDrawString(int x, int y, int size, String string) {
        Font font = new Font("Sans Serif", Font.PLAIN, size);
        Graphics2D graphics = frameBuffer.createGraphics();
        FontMetrics metrics = graphics.getFontMetrics(font);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setFont(font);
        graphics.drawString(string, x, y);
        graphics.dispose();
        return mouseStatus(x, y, metrics.stringWidth(string), metrics.getHeight());
    }

    public int UIDrawString(int x, int y, int size, String string, Color color) {
        Font font = new Font("Sans Serif", Font.PLAIN, size);
        Graphics2D graphics = frameBuffer.createGraphics();
        FontMetrics metrics = graphics.getFontMetrics(font);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setColor(color);
        graphics.setFont(font);
        graphics.drawString(string, x, y);
        graphics.dispose();
        return mouseStatus(x, y, metrics.stringWidth(string), metrics.getHeight());
    }

    public int UIDrawCenteredString(int x, int y, int size, String string) {
        Font font = new Font("Sans Serif", Font.PLAIN, size);
        Graphics2D graphics = frameBuffer.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        FontMetrics metrics = graphics.getFontMetrics(font);
        int width = metrics.stringWidth(string);
        int height = metrics.getHeight();
        x = x - (width / 2);
        y = y - (height / 2);
        graphics.setFont(font);
        graphics.drawString(string, x, y);
        graphics.dispose();
        return mouseStatus(x, y, width, height);
    }

    public int UIDrawCenteredString(int x, int y, int size, String string, Color color) {
        Font font = new Font("Sans Serif", Font.PLAIN, size);
        Graphics2D graphics = frameBuffer.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        FontMetrics metrics = graphics.getFontMetrics(font);
        Rectangle2D dimensions = metrics.getStringBounds(string, graphics);
        int width = (int) dimensions.getWidth();
        int height = (int) dimensions.getHeight();
        x = x - (width / 2);
        y = y + metrics.getDescent();
        graphics.setFont(font);
        graphics.setColor(color);
        graphics.drawString(string, x, y);
        graphics.dispose();
        return mouseStatus(x, y, width, height);
    }

    public boolean UIDrawButton(int x, int y, int w, int h, int fontSize, Color backColor, Color hoverColor, Color textColor, String text, boolean centerText) {
        if(UIDrawFilledRect(x, y, w, h, backColor, hoverColor) == 2) {
            return true;
        }

        if(centerText) UIDrawCenteredString((x + (w / 2)), (y + (h / 2)), fontSize, text, textColor);
        else UIDrawString(x, y + 15, fontSize, text, textColor);
        return false;
    }
}
