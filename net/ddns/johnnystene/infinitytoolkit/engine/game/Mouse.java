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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {
	public int x = 0;
	public int y = 0;
	public boolean down = false;

	public boolean inArea(int cX, int cY, int cW, int cH) {
		if(x > cX && x < cX + cW && y > cY && y < cY + cH)
			return true;

		return false;
	}

	public int areaStatus(int x, int y, int w, int h) {
		if(inArea(x, y, w, h)) {
			if(down) return 2;
			else return 1;
		} else return 0;
	}

	// None of these should be called by the game, so they're not included in the docs.
	@Override
	public void mouseDragged(MouseEvent arg0) {}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		x = arg0.getX();
		y = arg0.getY();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {
		down = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		down = false;
	}

}
