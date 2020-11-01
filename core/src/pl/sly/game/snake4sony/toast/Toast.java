package pl.sly.game.snake4sony.toast;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

import pl.sly.game.snake4sony.config.GameConfig;

/**
 * A class that represents toast message.
 */
public class Toast implements Disposable {

    private BitmapFont bitmapFont;
    private GlyphLayout glyphLayout;
    private Vector2 position;
    private PositionX positionX = PositionX.CENTER;
    private PositionY positionY = PositionY.CENTER;
    private float marginX;
    private float marginY;

    /**
     * Constructor.
     *
     * @param bitmapFont The instance of {@link BitmapFont} for draw message.
     */
    public Toast(BitmapFont bitmapFont) {
        this.bitmapFont = bitmapFont;
        glyphLayout = new GlyphLayout();
    }

    /**
     * Constructor.
     *
     * @param bitmapFont The instance of {@link BitmapFont} for draw message.
     * @param message The instance of {@link String} to draw.
     */
    public Toast(BitmapFont bitmapFont, String message) {
        this.bitmapFont = bitmapFont;
        glyphLayout = new GlyphLayout();
        glyphLayout.setText(bitmapFont, message);
    }

    /**
     * Set toast {@link PositionX}
     *
     * @param positionX The toast {@link PositionX}.
     */
    public void setPositionX(PositionX positionX) {
        this.positionX = positionX;
    }

    /**
     * Set toast {@link PositionY}
     *
     * @param positionY The toast {@link PositionY}.
     */
    public void setPositionY(PositionY positionY) {
        this.positionY = positionY;
    }

    /**
     * Set toast margin X.
     *
     * @param marginX The toast margin X.
     */
    public void setMarginX(float marginX) {
        this.marginX = marginX;
    }

    /**
     * Set toast margin Y.
     *
     * @param marginY The toast margin Y.
     */
    public void setMarginY(float marginY) {
        this.marginY = marginY;
    }

    /**
     * Update toast message.
     *
     * @param message The toast message.
     */
    public void updateMessage(String message) {
        glyphLayout.setText(bitmapFont, message);
    }

    /**
     * Render toast via {@link SpriteBatch}.
     *
     * @param spriteBatch The batch for drawing objects.
     */
    public void render(SpriteBatch spriteBatch) {
        updatePosition();
        bitmapFont.draw(spriteBatch, glyphLayout, position.x, position.y);
    }

    @Override
    public void dispose() {
        bitmapFont.dispose();
    }

    /**
     * Update toast position.
     */
    private void updatePosition() {
        Vector2 position = new Vector2();

        switch (positionX) {
            case CENTER:
                position.x = (GameConfig.SCREEN_WIDTH - glyphLayout.width) / 2;
                break;
        }

        switch  (positionY) {
            case CENTER:
                position.y = (GameConfig.SCREEN_HEIGHT + glyphLayout.height) / 2 + marginY;
                break;
            case CENTER_ABOVE:
                position.y = (GameConfig.SCREEN_HEIGHT) / 2 + glyphLayout.height + marginY;
                break;
            case CENTER_BELOW:
                position.y = (GameConfig.SCREEN_HEIGHT) / 2 - marginY;
                break;
        }

        this.position = position;
    }

    /**
     * Position X type.
     */
    public enum PositionX {
        CENTER
    }

    /**
     * Position Y type.
     */
    public enum PositionY {
        CENTER, CENTER_ABOVE, CENTER_BELOW
    }
}
