package pl.sly.game.snake4sony.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import pl.sly.game.snake4sony.asset.ColorAsset;
import pl.sly.game.snake4sony.config.GameConfig;
import pl.sly.game.snake4sony.state.GameState;

/**
 * A class that represents game screen. Based on {@link Screen}
 */
public class GameScreen implements Screen {

    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;
    private GameState gameState;

    /**
     * Constructor.
     */
    public GameScreen() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT);
        viewport = new FitViewport(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT, camera);
        viewport.setScreenBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer = new ShapeRenderer();
        spriteBatch = new SpriteBatch();
        gameState = new GameState();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        // clear screen
        Gdx.gl.glClearColor(
                ColorAsset.SCREEN_BACKGROUND.r,
                ColorAsset.SCREEN_BACKGROUND.g,
                ColorAsset.SCREEN_BACKGROUND.b,
                ColorAsset.SCREEN_BACKGROUND.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // setup renderer
        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);
        spriteBatch.setProjectionMatrix(camera.combined);

        // update game
        gameState.update(delta);

        // render game
        gameState.renderGame(spriteBatch, shapeRenderer);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        gameState.stop();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        spriteBatch.dispose();
    }
}
