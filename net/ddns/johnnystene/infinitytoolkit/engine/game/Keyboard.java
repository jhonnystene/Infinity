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
 
// No, I didn't write this from scratch. Wrote a python script to do it for me haha

package net.ddns.johnnystene.infinitytoolkit.engine.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {
	public boolean KEY_A = false;
	public boolean KEY_B = false;
	public boolean KEY_C = false;
	public boolean KEY_D = false;
	public boolean KEY_E = false;
	public boolean KEY_F = false;
	public boolean KEY_G = false;
	public boolean KEY_H = false;
	public boolean KEY_I = false;
	public boolean KEY_J = false;
	public boolean KEY_K = false;
	public boolean KEY_L = false;
	public boolean KEY_M = false;
	public boolean KEY_N = false;
	public boolean KEY_O = false;
	public boolean KEY_P = false;
	public boolean KEY_Q = false;
	public boolean KEY_R = false;
	public boolean KEY_S = false;
	public boolean KEY_T = false;
	public boolean KEY_U = false;
	public boolean KEY_V = false;
	public boolean KEY_W = false;
	public boolean KEY_X = false;
	public boolean KEY_Y = false;
	public boolean KEY_Z = false;
	public boolean KEY_1 = false;
	public boolean KEY_2 = false;
	public boolean KEY_3 = false;
	public boolean KEY_4 = false;
	public boolean KEY_5 = false;
	public boolean KEY_6 = false;
	public boolean KEY_7 = false;
	public boolean KEY_8 = false;
	public boolean KEY_9 = false;
	public boolean KEY_0 = false;
	public boolean KEY_CONTROL = false;
	public boolean KEY_SPACE = false;
	public boolean KEY_SHIFT = false;
	public boolean KEY_ESCAPE = false;
	public boolean KEY_ENTER = false;
	public boolean KEY_BACKSPACE = false;
	public void keyPressed(KeyEvent event) {
		int keycode = event.getKeyCode();
		if(keycode == KeyEvent.VK_A) KEY_A = true;
		if(keycode == KeyEvent.VK_B) KEY_B = true;
		if(keycode == KeyEvent.VK_C) KEY_C = true;
		if(keycode == KeyEvent.VK_D) KEY_D = true;
		if(keycode == KeyEvent.VK_E) KEY_E = true;
		if(keycode == KeyEvent.VK_F) KEY_F = true;
		if(keycode == KeyEvent.VK_G) KEY_G = true;
		if(keycode == KeyEvent.VK_H) KEY_H = true;
		if(keycode == KeyEvent.VK_I) KEY_I = true;
		if(keycode == KeyEvent.VK_J) KEY_J = true;
		if(keycode == KeyEvent.VK_K) KEY_K = true;
		if(keycode == KeyEvent.VK_L) KEY_L = true;
		if(keycode == KeyEvent.VK_M) KEY_M = true;
		if(keycode == KeyEvent.VK_N) KEY_N = true;
		if(keycode == KeyEvent.VK_O) KEY_O = true;
		if(keycode == KeyEvent.VK_P) KEY_P = true;
		if(keycode == KeyEvent.VK_Q) KEY_Q = true;
		if(keycode == KeyEvent.VK_R) KEY_R = true;
		if(keycode == KeyEvent.VK_S) KEY_S = true;
		if(keycode == KeyEvent.VK_T) KEY_T = true;
		if(keycode == KeyEvent.VK_U) KEY_U = true;
		if(keycode == KeyEvent.VK_V) KEY_V = true;
		if(keycode == KeyEvent.VK_W) KEY_W = true;
		if(keycode == KeyEvent.VK_X) KEY_X = true;
		if(keycode == KeyEvent.VK_Y) KEY_Y = true;
		if(keycode == KeyEvent.VK_Z) KEY_Z = true;
		if(keycode == KeyEvent.VK_1) KEY_1 = true;
		if(keycode == KeyEvent.VK_2) KEY_2 = true;
		if(keycode == KeyEvent.VK_3) KEY_3 = true;
		if(keycode == KeyEvent.VK_4) KEY_4 = true;
		if(keycode == KeyEvent.VK_5) KEY_5 = true;
		if(keycode == KeyEvent.VK_6) KEY_6 = true;
		if(keycode == KeyEvent.VK_7) KEY_7 = true;
		if(keycode == KeyEvent.VK_8) KEY_8 = true;
		if(keycode == KeyEvent.VK_9) KEY_9 = true;
		if(keycode == KeyEvent.VK_0) KEY_0 = true;
		if(keycode == KeyEvent.VK_CONTROL) KEY_CONTROL = true;
		if(keycode == KeyEvent.VK_SPACE) KEY_SPACE = true;
		if(keycode == KeyEvent.VK_SHIFT) KEY_SHIFT = true;
		if(keycode == KeyEvent.VK_ESCAPE) KEY_ESCAPE = true;
		if(keycode == KeyEvent.VK_ENTER) KEY_ENTER = true;
		if(keycode == KeyEvent.VK_BACK_SPACE) KEY_BACKSPACE = true;
	}
	
	public void keyReleased(KeyEvent event) {
		int keycode = event.getKeyCode();
		if(keycode == KeyEvent.VK_A) KEY_A = false;
		if(keycode == KeyEvent.VK_B) KEY_B = false;
		if(keycode == KeyEvent.VK_C) KEY_C = false;
		if(keycode == KeyEvent.VK_D) KEY_D = false;
		if(keycode == KeyEvent.VK_E) KEY_E = false;
		if(keycode == KeyEvent.VK_F) KEY_F = false;
		if(keycode == KeyEvent.VK_G) KEY_G = false;
		if(keycode == KeyEvent.VK_H) KEY_H = false;
		if(keycode == KeyEvent.VK_I) KEY_I = false;
		if(keycode == KeyEvent.VK_J) KEY_J = false;
		if(keycode == KeyEvent.VK_K) KEY_K = false;
		if(keycode == KeyEvent.VK_L) KEY_L = false;
		if(keycode == KeyEvent.VK_M) KEY_M = false;
		if(keycode == KeyEvent.VK_N) KEY_N = false;
		if(keycode == KeyEvent.VK_O) KEY_O = false;
		if(keycode == KeyEvent.VK_P) KEY_P = false;
		if(keycode == KeyEvent.VK_Q) KEY_Q = false;
		if(keycode == KeyEvent.VK_R) KEY_R = false;
		if(keycode == KeyEvent.VK_S) KEY_S = false;
		if(keycode == KeyEvent.VK_T) KEY_T = false;
		if(keycode == KeyEvent.VK_U) KEY_U = false;
		if(keycode == KeyEvent.VK_V) KEY_V = false;
		if(keycode == KeyEvent.VK_W) KEY_W = false;
		if(keycode == KeyEvent.VK_X) KEY_X = false;
		if(keycode == KeyEvent.VK_Y) KEY_Y = false;
		if(keycode == KeyEvent.VK_Z) KEY_Z = false;
		if(keycode == KeyEvent.VK_1) KEY_1 = false;
		if(keycode == KeyEvent.VK_2) KEY_2 = false;
		if(keycode == KeyEvent.VK_3) KEY_3 = false;
		if(keycode == KeyEvent.VK_4) KEY_4 = false;
		if(keycode == KeyEvent.VK_5) KEY_5 = false;
		if(keycode == KeyEvent.VK_6) KEY_6 = false;
		if(keycode == KeyEvent.VK_7) KEY_7 = false;
		if(keycode == KeyEvent.VK_8) KEY_8 = false;
		if(keycode == KeyEvent.VK_9) KEY_9 = false;
		if(keycode == KeyEvent.VK_0) KEY_0 = false;
		if(keycode == KeyEvent.VK_CONTROL) KEY_CONTROL = false;
		if(keycode == KeyEvent.VK_SPACE) KEY_SPACE = false;
		if(keycode == KeyEvent.VK_SHIFT) KEY_SHIFT = false;
		if(keycode == KeyEvent.VK_ESCAPE) KEY_ESCAPE = false;
		if(keycode == KeyEvent.VK_ENTER) KEY_ENTER = false;
		if(keycode == KeyEvent.VK_BACK_SPACE) KEY_BACKSPACE = false;
	}
}
