package net.ddns.johnnystene.infinitytoolkit.engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class World {
	public ArrayList<WorldItem> items;
	public ArrayList<InventoryItem> pickups;
	public BufferedImage backdrop;
	
	public int width;
	public int height;
	
	public World() {
		items = new ArrayList<>();
		pickups = new ArrayList<>();
		width = 10240;
		height = 10240;
		backdrop = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}
	
	public World(String path) {
		items = new ArrayList<>();
		pickups = new ArrayList<>();
		width = 4096;
		height = 4096;
		backdrop = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		try { 
			BufferedImage temp = ImageIO.read(this.getClass().getResourceAsStream(path));
			Graphics2D graphics = backdrop.createGraphics();
			graphics.drawImage(temp, 0, 0, null);
			graphics.dispose();
		} catch(Exception e) {
			System.out.println("World load error! Can't load " + path);
		}
	}
	
	public void renderTo(Graphics2D graphics, boolean debug) {
		//Raster newFB = backdrop.getData(new Rectangle(0, 0, width, height));
		//image.setData(newFB);
		graphics.drawImage(backdrop, 0, 0, null);
		
		for(WorldItem item : items) {
			graphics.drawImage(item.sprite.image, (int) item.x, (int) item.y, null);
			if(debug) {
				graphics.setColor(Color.BLACK);
				graphics.drawRect((int) item.x, (int) item.y, item.width, item.height);
				graphics.setColor(Color.BLUE);
				graphics.drawRect((int) item.x + item.hitboxX, (int) item.y + item.hitboxY, item.hitboxWidth, item.hitboxHeight);
			}
		}

		for(InventoryItem item : pickups) {
			if(item.inWorld) {
				graphics.drawImage(item.image, item.x, item.y, null);
				if(debug) {
					graphics.setColor(Color.RED);
					graphics.drawRect(item.x, item.y, item.width, item.height);
				}
			}
		}
		graphics.dispose();
	}
	
	public void renderTo(Graphics2D graphics, int viewportX, int viewportY, int viewportW, int viewportH, boolean debug) {
		graphics.drawImage(backdrop, 0 - viewportX, 0 - viewportY, null);

		for(WorldItem item : items) {
			graphics.drawImage(item.sprite.image, (int) item.x - viewportX, (int) item.y - viewportY, null);
			if(debug) {
				graphics.setColor(Color.BLACK);
				graphics.drawRect((int) item.x - viewportX, (int) item.y - viewportY, item.width, item.height);
				graphics.setColor(Color.BLUE);
				graphics.drawRect(((int) item.x + item.hitboxX) - viewportX, ((int) item.y + item.hitboxY) - viewportY, item.hitboxWidth, item.hitboxHeight);
			}
		}

		for(InventoryItem item : pickups) {
			if(item.inWorld) {
				graphics.drawImage(item.image, item.x - viewportX, item.y - viewportY, null);
				if(debug) {
					graphics.setColor(Color.RED);
					graphics.drawRect(item.x - viewportX, item.y - viewportY, item.width, item.height);
				}
			}
		}

		graphics.dispose();
	}
	
	public void createCollisionLine(int startX, int startY, int endX, int endY) {
		if(startX == endX) { // Vertical Line
			int height = Math.abs(startY - endY);
			WorldItem item = new WorldItem(1, height, new Color(0, 0, 0, 0));
			item.x = endX;
			if(startY > endY) item.y = endY;
			else item.y = startY;
			items.add(item);
		} else if(startY == endY) { // Horizontal Line
			int width = Math.abs(startX - endX);
			WorldItem item = new WorldItem(width, 1, Color.MAGENTA);
			item.y = startY;
			if(startX > endX) item.x = endX;
			else item.x = startX;
			items.add(item);
		} else { // Diagonal line
			// DDA Line Drawing Algorithm
			int dx = endX - startX;
			int dy = endY - startY;
			int steps = 0;

			if(Math.abs(dx) > Math.abs(dy)) steps = Math.abs(dx);
			else steps = Math.abs(dy);

			float xIncrement = dx / (float) steps;
			float yIncrement = dy / (float) steps;

			float x = startX;
			float y = startY;

			for(int v = 0; v < steps; v ++) {
				WorldItem item = new WorldItem(1, 1, Color.MAGENTA);
				item.x = x;
				item.y = y;
				items.add(item);
				x += xIncrement;
				y += yIncrement;
			}
		}
	}
	
	public void loadMapFile(String path) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(path), "UTF-8"));
			String inputline;
	
			// Line format:
			// X1,Y1 X2,Y2
	
			while((inputline = in.readLine()) != null) {

				// We need to get the coordinates for the line - there will be 2 per line.
				String[] fullCoords = inputline.split(" ");
				String coordSet0 = fullCoords[0];
				String coordSet1 = fullCoords[1];
	
				// Next, we need to split those into ints.
				int[] coords0 = {0, 0};
				int[] coords1 = {0, 0};
	
				// I'm gonna look back at this in a week and have know clue what the fuck i was doing haha
				coords0[0] = Integer.parseInt(coordSet0.split(",")[0]);
				coords0[1] = Integer.parseInt(coordSet0.split(",")[1]);
				coords1[0] = Integer.parseInt(coordSet1.split(",")[0]);
				coords1[1] = Integer.parseInt(coordSet1.split(",")[1]);
	
				createCollisionLine(coords0[0], coords0[1], coords1[0], coords1[1]);
			}
		} catch(Exception e) {
			System.out.println("World load error! Can't load " + path);
		}
	}
}
