package pl.sly.game.snake4sony.type;

/**
 * Direction type of snake {@link pl.sly.game.snake4sony.actor.model.Head}
 */
public enum DirectionType {

    LEFT, RIGHT, UP, DOWN;

    /**
     * Check if new direction is opposite to current one.
     *
     * @param directionType The new direction to check.
     * @return true/false if direction is opposite.
     */
    public boolean isOppositeDirection(DirectionType directionType) {
        if (this == LEFT && directionType == RIGHT) {
            return true;
        }
        if (this == RIGHT && directionType == LEFT) {
            return true;
        }
        if (this == UP && directionType == DOWN) {
            return true;
        }
        if (this == DOWN && directionType == UP) {
            return true;
        }

        return false;
    }
}
