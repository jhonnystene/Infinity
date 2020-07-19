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
 
package net.ddns.johnnystene.infinitytoolkit.engine;

import net.ddns.johnnystene.infinitytoolkit.engine.ImageUtils;

import java.awt.image.BufferedImage;

public class InventoryItem {
    public String name;
    public BufferedImage image;
    public int id;

    public boolean inWorld = false;
    public int x = 0;
    public int y = 0;
    public int width = 64;
    public int height = 64;

    public InventoryItem(String n, BufferedImage i, int itemId) {
        name = n;
        id = itemId;
        image = ImageUtils.resize(i, 64, 64);
    }

    public InventoryItem(String n, BufferedImage i, int itemId, int px, int py) {
        name = n;
        id = itemId;
        image = ImageUtils.resize(i, 64, 64);
        x = px;
        y = py;
        inWorld = true;
    }

}
