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

public class Test {
    public static void main(String[] args) {
        Game game = new Game("Infinity Toolkit - Test application", 800, 600) {
            @Override
            public void doTick() {
                System.out.println("Game tick!");
            }
        };
        game.start();
    }
}
