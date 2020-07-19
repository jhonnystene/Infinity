package net.ddns.johnnystene.infinitytoolkit.engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class WorldItem {
	public float x;
	public float y;
	public int width;
	public int height;
	
	public int hitboxX;
	public int hitboxY;
	public int hitboxWidth;
	public int hitboxHeight;
	
	boolean[] collisionLayer = {true, false, false};
	boolean[] collisionMask = {true, false, false};
	
	// Directions
	public static int SW = 0;
	public static int W = 1;
	public static int NW = 2;
	public static int N = 3;
	public static int NE = 4;
	public static int E = 5;
	public static int SE = 6;
	public static int S = 7;
	
	public Sprite sprite;
	public Sprite[] isometricSprites = new Sprite[8];
	public int direction = 0;
	public boolean isometricItem = false;

	public WorldItem(Sprite[] sprites) {
		isometricSprites = sprites;
		sprite = isometricSprites[0];
		width = sprite.image.getWidth();
		height = sprite.image.getHeight();
		hitboxX = 0;
		hitboxY = 0;
		hitboxWidth = width;
		hitboxHeight = height;
	}

	public WorldItem(String path) {
		x = 0;
		y = 0;
		
		loadSprite(path);
	}
	
	public WorldItem(String path, int sX, int sY) {
		x = sX;
		y = sY;
		
		loadSprite(path);
	}

	public WorldItem(Sprite s) {
		sprite = s;
		x = 0;
		y = 0;
	}

	public WorldItem(Sprite s, int sX, int sY) {
		sprite = s;
		x = sX;
		y = sY;
	}
	
	public WorldItem(String path, int sX, int sY, int hX, int hY, int hW, int hH) {
		x = sX;
		y = sY;
		
		loadSprite(path);
		
		hitboxX = hX;
		hitboxY = hY;
		hitboxWidth = hW;
		hitboxHeight = hH;
	}
	
	public WorldItem(int w, int h, Color color) {
		sprite = new Sprite(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics = sprite.image.createGraphics();
		graphics.setColor(color);
		graphics.fillRect(0, 0, width, height);
		graphics.dispose();
		width = w;
		height = h;
		hitboxX = 0;
		hitboxY = 0;
		hitboxWidth = w;
		hitboxHeight = h;
	}
	
	public void resize(int w, int h) {
		sprite.resize(w, h);
		for(int i = 0; i < 8; i++) {
			isometricSprites[i].resize(w, h);
		}
		width = w;
		height = h;
	}
	
	public void loadSprite(String path) {
		sprite = new Sprite(path);
		for(int i = 0; i < 8; i++) isometricSprites[i] = sprite;
	}
	
	public void loadSprite(String path, int direction) {
		isometricSprites[direction] = new Sprite(path);
	}
	
	public void pointInDirection(int d) {
		if(isometricItem) {
			if(direction < 8)
				sprite = isometricSprites[d];
			else 
				System.out.println("Warning: Tried to point an isometric sprite in a non-existant direction.");
		} else
			System.out.println("Warning: Tried to point a non-isometric sprite in a direction.");
		direction = d;
	}
	
	public void lookTowards(int x, int y) {
		if(x > 0) {
			if(y > 0)
				pointInDirection(SE);
			else if(y < 0)
				pointInDirection(NE);
			else
				pointInDirection(E);
		} else if(x < 0) {
			if(y > 0)
				pointInDirection(SW);
			else if(y < 0)
				pointInDirection(NW);
			else
				pointInDirection(W);
		} else {
			if(y > 0)
				pointInDirection(S);
			else if(y < 0)
				pointInDirection(N);
		}
	}
	
	public boolean collidingWith(WorldItem item) {
		if(item == null) return false;
		if(item == this) return false;
		
		for(int currentLayer = 0; currentLayer < 3; currentLayer ++) {
			if(item.collisionLayer[currentLayer] && collisionMask[currentLayer]) {
				int myX = (int) (x + hitboxX);
				int myY = (int) (y + hitboxY);
				int myW = hitboxWidth;
				int myH = hitboxHeight;
				int itemX = (int) (item.x + item.hitboxX);
				int itemY = (int) (item.y + item.hitboxY);
				int itemW = item.hitboxWidth;
				int itemH = item.hitboxHeight;
				
				if(myX < itemX + itemW && myX + myW > itemX && 
						myY < itemY + itemH && myY + myH > itemY) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void moveAndCollide(float moveX, float moveY, ArrayList<WorldItem> collisionItemLayer) {
		x = x + moveX;
		for(WorldItem item : collisionItemLayer) {
			while(collidingWith(item)) {
				if(moveX > 0) {
					x = x - 1;
				} else {
					x = x + 1;
				}
			}
		}
		
		y = y + moveY;
		for(WorldItem item : collisionItemLayer) {
			while(collidingWith(item)) {
				while(collidingWith(item)) {
					if(moveY > 0) {
						y = y- 1;
					} else {
						y = y + 1;
					}
				}
			}
		}
		
		if(isometricItem) {
			lookTowards((int) moveX, (int) moveY);
		}

		if(x < 0) x = 0;
		if(x > 10240) x = 10240;
		if(y < 0) y = 0;
		if(y > 10240) y = 10240;
	}

	public boolean inArea(int arg0, int arg1, int arg2, int arg3) {
		int myX = (int) (x + hitboxX);
		int myY = (int) (y + hitboxY);
		int myW = hitboxWidth;
		int myH = hitboxHeight;

		if(myX < arg0 + arg2 && myX + myW > arg0 &&
				myY < arg1 + arg3 && myY + myH > arg1) {
			return true;
		}

		return false;
	}
}
