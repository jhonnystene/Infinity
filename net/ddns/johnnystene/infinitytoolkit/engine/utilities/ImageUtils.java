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
 
package net.ddns.johnnystene.infinitytoolkit.engine.utilities;

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
