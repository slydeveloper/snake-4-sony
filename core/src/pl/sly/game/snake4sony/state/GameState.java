package pl.sly.game.snake4sony.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;

import pl.sly.game.snake4sony.actor.Food;
import pl.sly.game.snake4sony.actor.Snake;
import pl.sly.game.snake4sony.config.GameConfig;
import pl.sly.game.snake4sony.game.ScoreCollector;
import pl.sly.game.snake4sony.hud.ScoreHUD;
import pl.sly.game.snake4sony.input.DirectionListener;
import pl.sly.game.snake4sony.input.InputHandler;
import pl.sly.game.snake4sony.input.SwipeHandler;
import pl.sly.game.snake4sony.manager.ToastManager;
import pl.sly.game.snake4sony.object.Board;
import pl.sly.game.snake4sony.toast.ToastTimerListener;
import pl.sly.game.snake4sony.type.DirectionType;

/**
 * A class that represent game logic.
 */
public class GameState implements ToastTimerListener, DirectionListener, Disposable {

    private Board board;
    private Snake snake;
    private Food food;
    private ScoreCollector scoreCollector;
    private ScoreHUD scoreHud;
    private ToastManager toastManager;
    private float timeDelta;
    private boolean isRunning;

    /**
     * Constructor.
     */
    public GameState() {
        board = new Board();
        snake = new Snake();
        food = new Food();
        toastManager = new ToastManager();
        scoreCollector = new ScoreCollector();
        scoreHud = new ScoreHUD(scoreCollector);
        toastManager.showStartToast(this);
        setupInputProcessor();
    }

    /**
     * Update state between render.
     *
     * @param delta The time in seconds since the last render.
     */
    public void update(float delta) {
        if (isRunning) {
            moveSnake(delta);
            handleCollision();
        }
        toastManager.update(delta);
    }

    /**
     * Stop game.
     */
    public void stop() {
        gameStop();
    }

    /**
     * Render game.
     *
     * @param spriteBatch The batch for drawing objects.
     * @param shapeRenderer The batch for draw shapes.
     */
    public void renderGame(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        board.render(shapeRenderer);
        shapeRenderer.end();

        spriteBatch.begin();
        snake.render(spriteBatch);
        food.render(spriteBatch);
        scoreHud.render(spriteBatch);
        toastManager.render(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void onLeft() {
        snake.updateDirection(DirectionType.LEFT);
    }

    @Override
    public void onRight() {
        snake.updateDirection(DirectionType.RIGHT);
    }

    @Override
    public void onUp() {
        snake.updateDirection(DirectionType.UP);
    }

    @Override
    public void onDown() {
        snake.updateDirection(DirectionType.DOWN);
    }

    @Override
    public void dispose() {
        snake.dispose();
        food.dispose();
        scoreHud.dispose();
        toastManager.dispose();
    }

    @Override
    public void onTimeOut() {
        resetGame();
    }

    /**
     * Move snake actor.
     *
     * @param delta The time in seconds since the last render.
     */
    private void moveSnake(float delta) {
        timeDelta -= delta;
        if (timeDelta <= 0) {
            snake.move();
            timeDelta = GameConfig.SNAKE_DELAY_TIME;
        }
    }

    /**
     * Handle snake collisions with food and snake body.
     */
    private void handleCollision() {
        if (snake.isFoodCollision(food.getPosition())) {
            snake.expand();
            resetFood();
            scoreCollector.addScore();
        }

        if (snake.isBodyCollision()) {
            snake.crash();
            gameStop();
            toastManager.showStartToast(this);
        }
    }

    /**
     * Reset food position.
     */
    private void resetFood() {
        food.reset(snake.getAllBodyPositionList());
    }

    /**
     * Start game.
     */
    private void gameStart() {
        isRunning = true;
    }

    /**
     * Stop game.
     */
    private void gameStop() {
        isRunning = false;
    }

    /**
     * Reset game state.
     */
    private void resetGame() {
        toastManager.hideStartToast();
        snake.reset();
        scoreCollector.reset();
        resetFood();
        gameStart();
    }

    /**
     * Prepare input processor for handling input.
     */
    private void setupInputProcessor() {
        InputProcessor swipeHandler = new SwipeHandler(this);
        InputProcessor inputHandler = new InputHandler(this);
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(swipeHandler);
        inputMultiplexer.addProcessor(inputHandler);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }
}
