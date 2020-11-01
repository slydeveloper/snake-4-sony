package pl.sly.game.snake4sony.actor.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import pl.sly.game.snake4sony.config.GameConfig;

/**
 * A class that represents body of the snake actor.
 */
public class Body {

    private static final float ALPHA_FOG_VALUE = 0.5f;

    private Sprite sprite;
    private Vector2 position;

    /**
     * Constructor of the body.
     *
     * @param texture The {@link Texture} resource.
     * @param position The {@link Vector2} position.
     */
    public Body(Texture texture, Vector2 position) {
        this.position = position;
        sprite = new Sprite(texture);
        sprite.setSize(GameConfig.SNAKE_BODY_CELL_SIZE, GameConfig.SNAKE_BODY_CELL_SIZE);
    }

    /**
     * Get body {@link Vector2} position.
     *
     * @return body position.
     */
    public Vector2 getPosition() {
        return position;
    }

    /**
     * Update body {@link Vector2} position.
     *
     * @param position The new position of body.
     */
    public void updatePosition(Vector2 position) {
        this.position = position;
    }

    /**
     * Update body {@link Vector2#x} position.
     * @param x The new {@link Vector2#x} position of body.
     */
    public void updatePositionX(float x) {
        position.x = x;
    }

    /**
     * Update body {@link Vector2#y} position.
     * @param y The new {@link Vector2#y} position of body.
     */
    public void updatePositionY(float y) {
        position.y = y;
    }

    /**
     * Get body {@link Vector2#x} position.
     * @return body {@link Vector2#x} position.
     */
    public float getPositionX() {
        return position.x;
    }

    /**
     * Get body {@link Vector2#y} position.
     * @return body {@link Vector2#y} position.
     */
    public float getPositionY() {
        return position.y;
    }

    /**
     * Render body via {@link SpriteBatch}.
     *
     * @param spriteBatch The batch for drawing objects.
     */
    public void render(SpriteBatch spriteBatch) {
        sprite.setPosition(
                GameConfig.SNAKE_BODY_X + GameConfig.SNAKE_BODY_CELL_SIZE * this.position.x,
                GameConfig.SNAKE_BODY_Y + GameConfig.SNAKE_BODY_CELL_SIZE * this.position.y);
        sprite.draw(spriteBatch);
    }

    /**
     * Draw foggy effect of body, using {@link Sprite#setAlpha(float)}
     */
    public void fog() {
        sprite.setAlpha(ALPHA_FOG_VALUE);
    }
}
