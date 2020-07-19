package net.ddns.johnnystene.infinitytoolkit.engine;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class ImageUtils {
	public static int getType(BufferedImage image) {
		if(image.getColorModel().hasAlpha()) return BufferedImage.TYPE_INT_ARGB;
		else return BufferedImage.TYPE_INT_RGB;
	}

	public static BufferedImage resize(BufferedImage image, int width, int height) {
		Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_FAST);
		BufferedImage finalImage = new BufferedImage(width, height, getType(image));
		
		Graphics2D graphics = finalImage.createGraphics();
		graphics.drawImage(scaledImage, 0, 0, null);
		graphics.dispose();
		
		return finalImage;
	}

	public static BufferedImage getArea(BufferedImage image, int x, int y, int width, int height) {
		Raster newImage = image.getData(new Rectangle(x, y, width, height)).createTranslatedChild(0, 0);
		BufferedImage finalImage = new BufferedImage(width, height, getType(image));
		finalImage.setData(newImage);
		return finalImage;
	}
}
