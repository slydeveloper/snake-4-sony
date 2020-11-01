package pl.sly.game.snake4sony.actor.model;

import com.badlogic.gdx.math.Vector2;

import pl.sly.game.snake4sony.config.GameConfig;
import pl.sly.game.snake4sony.type.DirectionType;

/**
 * A class that represents head of the snake actor.
 */
public class Head {

    public static final int SNAKE_MOVE_STEP = 1;

    private Body body;
    private DirectionType directionType;

    /**
     * Constructor of the Head.
     *
     * @param body The {@link Body} instance.
     * @param directionType The {@link DirectionType} that represents direction of the head.
     */
    public Head(Body body, DirectionType directionType) {
        this.body = body;
        this.directionType = directionType;
    }

    /**
     * Update {@link DirectionType} of the Head for moving the Snake.
     *
     * @param directionType The {@link DirectionType} for update head direction.
     */
    public void updateDirection(DirectionType directionType) {
        if (!directionType.isOppositeDirection(this.directionType)) {
            this.directionType = directionType;
        }
        move();
        handleWallCollision();
    }

    /**
     * Get {@link Vector2} position of the head.
     *
     * @return {@link Vector2} position of the head.
     */
    public Vector2 getPosition() {
        return body.getPosition();
    }

    /**
     * Move head based on {@link DirectionType}
     */
    private void move() {
        Vector2 position = body.getPosition();

        switch (directionType) {
            case LEFT:
                body.updatePosition(new Vector2(position.x - SNAKE_MOVE_STEP, position.y));
                break;
            case RIGHT:
                body.updatePosition(new Vector2(position.x + SNAKE_MOVE_STEP, position.y));
                break;
            case UP:
                body.updatePosition(new Vector2(position.x, position.y + SNAKE_MOVE_STEP));
                break;
            case DOWN:
                body.updatePosition(new Vector2(position.x, position.y - SNAKE_MOVE_STEP));
                break;
        }
    }

    /**
     * Handle wall collision. If the head move out the board then move head to the opposite side.
     */
    private void handleWallCollision() {
        if (body.getPositionX() >= GameConfig.BOARD_WIDTH) {
            body.updatePositionX(0);
        }
        if (body.getPositionX() < 0) {
            body.updatePositionX(GameConfig.BOARD_WIDTH - 1);
        }
        if (body.getPositionY() >= GameConfig.BOARD_HEIGHT) {
            body.updatePositionY(0);
        }
        if (body.getPositionY() < 0) {
            body.updatePositionY(GameConfig.BOARD_HEIGHT - 1);
        }
    }
}
