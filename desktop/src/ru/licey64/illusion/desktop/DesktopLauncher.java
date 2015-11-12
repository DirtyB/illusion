package ru.licey64.illusion.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.licey64.illusion.IllusionGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Illusion";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new IllusionGame(), config);
	}
}
