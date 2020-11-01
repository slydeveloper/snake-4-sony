package pl.sly.game.snake4sony;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import pl.sly.game.snake4sony.manager.ScreenManager;

/**
 * Main game class based on {@link Game}
 */
public class Snake4Sony extends Game {

    private ScreenManager screenManager;

    @Override
    public void create() {
        screenManager = new ScreenManager(this);
        screenManager.changeScreen(ScreenManager.ScreenType.SPLASH);
    }

    @Override
    public void render() {
        super.render();
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        screenManager.dispose();
    }
}
