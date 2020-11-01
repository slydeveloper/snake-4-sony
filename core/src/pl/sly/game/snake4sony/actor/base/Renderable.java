package pl.sly.game.snake4sony.actor.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Interface for renderable resources.
 */
public interface Renderable {

    /**
     * Render resources via {@link SpriteBatch}
     *
     * @param batch The batch for drawing objects.
     */
    void render(SpriteBatch batch);
}
