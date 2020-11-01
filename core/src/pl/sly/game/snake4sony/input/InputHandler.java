package pl.sly.game.snake4sony.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * A class that represents a processor used to receive input events from a keyboard, TV remote
 * or touch screen etc.
 */
public class InputHandler implements InputProcessor {

    private DirectionListener directionListener;

    /**
     * Constructor.
     *
     * @param directionListener The {@link DirectionListener} for handling input.
     */
    public InputHandler(DirectionListener directionListener) {
        this.directionListener = directionListener;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                directionListener.onUp();
                break;
            case Input.Keys.DOWN:
                directionListener.onDown();
                break;
            case Input.Keys.LEFT:
                directionListener.onLeft();
                break;
            case Input.Keys.RIGHT:
                directionListener.onRight();
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
