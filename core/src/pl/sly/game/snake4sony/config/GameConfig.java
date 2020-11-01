package pl.sly.game.snake4sony.config;

/**
 * Low-level configuration of the game.
 */
public class GameConfig {

    // screen
    public static final int SCREEN_WIDTH = 854;
    public static final int SCREEN_HEIGHT = 480;

    // board size
    public static final int BOARD_CELL_SIZE = 40;
    public static final int BOARD_WIDTH = 19;
    public static final int BOARD_HEIGHT = 9;
    public static final float BOARD_PIX_WIDTH = BOARD_WIDTH * BOARD_CELL_SIZE;
    public static final float BOARD_PIX_HEIGHT = BOARD_HEIGHT * BOARD_CELL_SIZE;
    public static final float BOARD_X = SCREEN_WIDTH / 2 - BOARD_PIX_WIDTH / 2;
    public static final float BOARD_Y = SCREEN_HEIGHT / 2 - BOARD_PIX_HEIGHT / 2;

    // board frame
    public static final float BOARD_FRAME_IN_SIZE = 8;
    public static final float BOARD_FRAME_IN_X = BOARD_X - BOARD_FRAME_IN_SIZE;
    public static final float BOARD_FRAME_IN_Y = BOARD_Y - BOARD_FRAME_IN_SIZE;
    public static final float BOARD_FRAME_IN_WIDTH = BOARD_PIX_WIDTH + 2 * BOARD_FRAME_IN_SIZE;
    public static final float BOARD_FRAME_IN_HEIGHT = BOARD_PIX_HEIGHT + 2 * BOARD_FRAME_IN_SIZE;

    public static final float BOARD_FRAME_OUT_SIZE = 16;
    public static final float BOARD_FRAME_OUT_X = BOARD_X - BOARD_FRAME_OUT_SIZE;
    public static final float BOARD_FRAME_OUT_Y = BOARD_Y - BOARD_FRAME_OUT_SIZE;
    public static final float BOARD_FRAME_OUT_WIDTH = BOARD_PIX_WIDTH + 2 * BOARD_FRAME_OUT_SIZE;
    public static final float BOARD_FRAME_OUT_HEIGHT = BOARD_PIX_HEIGHT + 2 * BOARD_FRAME_OUT_SIZE;

    // snake
    public static final int SNAKE_BODY_INIT = 3;
    public static final int SNAKE_BODY_CELL_SIZE = BOARD_CELL_SIZE;
    public static final float SNAKE_BODY_X = BOARD_X;
    public static final float SNAKE_BODY_Y = BOARD_Y;
    public static final float SNAKE_DELAY_TIME = 0.20f; // 0.25f

    // food
    public static final int FOOD_CELL_SIZE = BOARD_CELL_SIZE;
    public static final float FOOD_START_X = BOARD_X;
    public static final float FOOD_START_Y = BOARD_Y;

    // points
    public static final int POINTS = 10;

    // HUD
    public static final float HUD_SCORE_MARGIN_TOP = 20;
    public static final float HUD_SCORE_X = BOARD_FRAME_OUT_X;
    public static final float HUD_SCORE_Y = SCREEN_HEIGHT - HUD_SCORE_MARGIN_TOP;

    // splash
    public static final float SPLASH_SCREEN_TIMEOUT = 2.0f;
}
