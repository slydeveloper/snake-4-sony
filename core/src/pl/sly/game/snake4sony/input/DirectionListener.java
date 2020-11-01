package pl.sly.game.snake4sony.input;

/**
 * An interface that represents listener for handling game input from a keyboard, TV remote
 * or touch screen etc.
 */
public interface DirectionListener {

    /**
     * Handle left input.
     */
    void onLeft();

    /**
     * Handle right input.
     */
    void onRight();

    /**
     * Handle up input.
     */
    void onUp();

    /**
     * Handle down input.
     */
    void onDown();
}
