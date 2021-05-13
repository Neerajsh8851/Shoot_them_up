package com.game.asteroid.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.game.asteroid.game.AsteroidMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		new LwjglApplication(new AsteroidMain(), "Asteroid", 800, 600);
	}
}