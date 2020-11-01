package pl.sly.game.snake4sony.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pl.sly.game.snake4sony.Snake4Sony;
import pl.sly.game.snake4sony.config.GameConfig;

/**
 * Main desktop application launcher.
 */
public class DesktopLauncher {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GameConfig.SCREEN_WIDTH;
		config.height = GameConfig.SCREEN_HEIGHT;
		new LwjglApplication(new Snake4Sony(), config);
	}
}
