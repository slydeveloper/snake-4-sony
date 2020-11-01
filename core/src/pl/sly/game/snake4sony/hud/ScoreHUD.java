package pl.sly.game.snake4sony.hud;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

import pl.sly.game.snake4sony.config.GameConfig;
import pl.sly.game.snake4sony.factory.BitmapFontFactory;
import pl.sly.game.snake4sony.game.ScoreCollector;

/**
 * A class that represents Head-Up Display for present score value.
 */
public class ScoreHUD implements Disposable {

    private static final String SCORE_LABEL = "SCORE: %d";

    private BitmapFontFactory bitmapFontFactory;
    private BitmapFont bitmapFont;
    private ScoreCollector scoreCollector;

    /**
     * Constructor.
     *
     * @param scoreCollector The instance of {@link ScoreCollector} which keeps score.
     */
    public ScoreHUD(ScoreCollector scoreCollector) {
        this.scoreCollector = scoreCollector;
        bitmapFontFactory = new BitmapFontFactory();
        bitmapFont = bitmapFontFactory.createFont(BitmapFontFactory.FontType.SCORE);
    }

    /**
     * Render body via {@link SpriteBatch}.
     *
     * @param spriteBatch The batch for drawing objects.
     */
    public void render(SpriteBatch spriteBatch) {
        String scoreLabel = String.format(SCORE_LABEL, scoreCollector.getScore());
        bitmapFont.draw(spriteBatch, scoreLabel, GameConfig.HUD_SCORE_X, GameConfig.HUD_SCORE_Y);
    }

    @Override
    public void dispose() {
        bitmapFont.dispose();
    }
}
