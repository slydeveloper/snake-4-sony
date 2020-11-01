package pl.sly.game.snake4sony.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import pl.sly.game.snake4sony.asset.ColorAsset;
import pl.sly.game.snake4sony.asset.FontAsset;

/**
 * A class that represents factory for producing {@link BitmapFont} instances
 * depends on {@link FontType}
 */
public class BitmapFontFactory {

    private static final int FONT_SIZE_SCORE = 18;
    private static final int FONT_SIZE_MESSAGE = 44;
    private static final int FONT_SIZE_SPLASH = 80;

    /**
     * Produces font depends on {@link FontType}.
     *
     * @param fontType The {@link FontType} to produce.
     * @return {@link BitmapFont} instance.
     */
    public BitmapFont createFont(FontType fontType) {
        switch (fontType) {
            case SCORE:
                return createScoreFont();
            case MESSAGE:
                return createMessageFont();
            case SPLASH:
                return createSplashFont();
        }
        return null;
    }

    /**
     * Produces {@link BitmapFont} that represents score font.
     *
     * @return {@link BitmapFont} of score font.
     */
    private BitmapFont createScoreFont() {
        FileHandle fileHandle = Gdx.files.internal(FontAsset.PIXEL.getPath());
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fileHandle);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = FONT_SIZE_SCORE;
        parameter.color = ColorAsset.HUD_FONT;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        return font;
    }

    /**
     * Produces {@link BitmapFont} that represents message font.
     *
     * @return {@link BitmapFont} of message font.
     */
    private BitmapFont createMessageFont() {
        FileHandle fileHandle = Gdx.files.internal(FontAsset.PIXEL.getPath());
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fileHandle);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = FONT_SIZE_MESSAGE;
        parameter.color = ColorAsset.TOAST_MESSAGE_FONT;
        parameter.shadowOffsetX = 2;
        parameter.shadowOffsetY = 2;
        parameter.shadowColor = Color.BLACK;
        parameter.borderColor = ColorAsset.HUD_FONT;
        parameter.borderWidth = 2;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        return font;
    }

    /**
     * Produces {@link BitmapFont} that represents splash font.
     *
     * @return {@link BitmapFont} of splash font.
     */
    private BitmapFont createSplashFont() {
        FileHandle fileHandle = Gdx.files.internal(FontAsset.PIXEL.getPath());
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fileHandle);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = FONT_SIZE_SPLASH;
        parameter.color = ColorAsset.TOAST_MESSAGE_FONT;
        parameter.shadowOffsetX = 2;
        parameter.shadowOffsetY = 2;
        parameter.shadowColor = Color.BLACK;
        parameter.borderColor = ColorAsset.HUD_FONT;
        parameter.borderWidth = 2;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        return font;
    }

    /**
     * Type of font.
     */
    public enum FontType {
        SCORE, MESSAGE, SPLASH
    }
}
