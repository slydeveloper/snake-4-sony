package pl.sly.game.snake4sony.actor.base;

import com.badlogic.gdx.utils.Disposable;

/**
 * Abstract class of game actor. Provides methods of {@link Renderable} and {@link Disposable}
 * for rendering and freeing resources.
 */
public abstract class BaseActor implements Renderable, Disposable {

    private boolean isVisible = true;

    /**
     * Check if actor is visible.
     *
     * @return isVisible flag value.
     */
    public boolean isVisible() {
        return isVisible;
    }

    /**
     * Sets if actor is visible.
     *
     * @param visible The flag that determines visibility.
     */
    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
