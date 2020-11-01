package pl.sly.game.snake4sony.object;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

import pl.sly.game.snake4sony.asset.ColorAsset;
import pl.sly.game.snake4sony.config.GameConfig;

/**
 * A class that represents game board.
 */
public class Board {

    /**
     * Render the game board.
     *
     * @param shapeRenderer The batch for draw shapes.
     */
    public void render(ShapeRenderer shapeRenderer) {
        renderBoardFrame(shapeRenderer);
        renderBoard(shapeRenderer);
    }

    /**
     * Render frame of the game board.
     *
     * @param shapeRenderer The batch for draw shapes.
     */
    private void renderBoardFrame(ShapeRenderer shapeRenderer) {
        // board frame out
        shapeRenderer.setColor(ColorAsset.BOARD_FRAME_OUT);
        shapeRenderer.rect(
                GameConfig.BOARD_FRAME_OUT_X,
                GameConfig.BOARD_FRAME_OUT_Y,
                GameConfig.BOARD_FRAME_OUT_WIDTH,
                GameConfig.BOARD_FRAME_OUT_HEIGHT);
        // board frame in
        shapeRenderer.setColor(ColorAsset.BOARD_FRAME_IN);
        shapeRenderer.rect(
                GameConfig.BOARD_FRAME_IN_X,
                GameConfig.BOARD_FRAME_IN_Y,
                GameConfig.BOARD_FRAME_IN_WIDTH,
                GameConfig.BOARD_FRAME_IN_HEIGHT);
    }

    /**
     * Render chess-style board.
     *
     * @param shapeRenderer The batch for draw shapes.
     */
    private void renderBoard(ShapeRenderer shapeRenderer) {
        List<Vector2> boardList = generateBoard();
        for (Vector2 position : boardList) {
            if (isEven(position)) {
                shapeRenderer.setColor(ColorAsset.BOARD_CHECKER_GREEN_LIGHT);
            } else {
                shapeRenderer.setColor(ColorAsset.BOARD_CHECKER_GREEN_DARK);
            }
            renderSquare(shapeRenderer, position);
        }
    }

    /**
     * Render a single board square.
     *
     * @param shapeRenderer The batch for draw shapes.
     * @param position The {@link Vector2} position of the square.
     */
    private void renderSquare(ShapeRenderer shapeRenderer, Vector2 position) {
        float drawPosX = GameConfig.BOARD_X + position.x * GameConfig.BOARD_CELL_SIZE;
        float drawPosY = GameConfig.BOARD_Y + position.y * GameConfig.BOARD_CELL_SIZE;
        shapeRenderer.rect(drawPosX, drawPosY, GameConfig.BOARD_CELL_SIZE, GameConfig.BOARD_CELL_SIZE);
    }

    /**
     * Check if {@link Vector2} coordinates are even.
     *
     * @param vector The {@link Vector2} coordinates to check.
     * @return true/false if even coordinates.
     */
    private boolean isEven(Vector2 vector) {
        return (vector.x + vector.y) % 2 == 0;
    }

    /**
     * Generate {@link List} of {@link Vector2} that represent the game board.
     *
     * @return game board as {@link List} of {@link Vector2}.
     */
    private static List<Vector2> generateBoard() {
        List<Vector2> boardList = new ArrayList<>();

        for (int posX = 0; posX < GameConfig.BOARD_WIDTH; posX++) {
            for (int posY = 0; posY < GameConfig.BOARD_HEIGHT; posY++) {
                boardList.add(new Vector2(posX, posY));
            }
        }

        return boardList;
    }
}
