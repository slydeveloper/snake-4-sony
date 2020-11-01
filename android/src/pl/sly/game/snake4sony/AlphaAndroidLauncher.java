package pl.sly.game.snake4sony;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import pl.sly.game.snake4sony.platform.SonyAlphaAndroidApplication;

/**
 * Main Android application launcher, based on {@link SonyAlphaAndroidApplication}
 */
public class AlphaAndroidLauncher extends SonyAlphaAndroidApplication {

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new Snake4Sony(), config);
	}
}
