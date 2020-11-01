package pl.sly.game.snake4sony.manager;

import com.badlogic.gdx.utils.Disposable;

import pl.sly.game.snake4sony.Snake4Sony;
import pl.sly.game.snake4sony.screen.GameScreen;
import pl.sly.game.snake4sony.screen.SplashScreen;

/**
 * A class that represents screen manager for render proper screen like splash or game.
 */
public class ScreenManager implements Disposable {

    private Snake4Sony snake4Sony;

    /**
     * Constructor.
     *
     * @param snake4Sony The main game class.
     */
    public ScreenManager(Snake4Sony snake4Sony) {
        this.snake4Sony = snake4Sony;
    }

    /**
     * Reload screen depends on type {@link ScreenType}
     *
     * @param screenType The type of screen.
     */
    public void changeScreen(ScreenType screenType) {
        dispose();
        switch (screenType) {
            case SPLASH:
                snake4Sony.setScreen(new SplashScreen(this));
                break;
            case GAME:
                snake4Sony.setScreen(new GameScreen());
                break;
        }
    }

    @Override
    public void dispose() {
        if (snake4Sony.getScreen() != null) {
            snake4Sony.getScreen().dispose();
        }
    }

    /**
     * Screen type.
     */
    public enum ScreenType {
        SPLASH, GAME
    }
}
