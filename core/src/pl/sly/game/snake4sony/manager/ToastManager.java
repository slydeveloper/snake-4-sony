package pl.sly.game.snake4sony.manager;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

import pl.sly.game.snake4sony.factory.BitmapFontFactory;
import pl.sly.game.snake4sony.toast.ToastTimerListener;
import pl.sly.game.snake4sony.toast.Toast;
import pl.sly.game.snake4sony.toast.ToastTimer;

/**
 * A class that represents manager of toast messages.
 */
public class ToastManager implements Disposable {

    private static final String MESSAGE_START_IN = "START IN:";
    private static final int MARGIN_Y_TOAST_MESSAGE = 10;
    private static final int MARGIN_Y_TOAST_TIMER_MESSAGE = 5;

    private BitmapFontFactory bitmapFontFactory;
    private Toast toastMessage;
    private ToastTimer toastTimer;

    /**
     * Constructor.
     */
    public ToastManager() {
        bitmapFontFactory = new BitmapFontFactory();
    }

    /**
     * Show "start in" toast message.
     *
     * @param toastTimerListener The {@link ToastTimerListener} instance for handle time out.
     */
    public void showStartToast(ToastTimerListener toastTimerListener) {
        buildStartToast();
        buildTimerToast(toastTimerListener);
    }

    /**
     * Hide "start in" toast message.
     */
    public void hideStartToast() {
        toastMessage = null;
        toastTimer = null;
    }

    /**
     * Update timer between render.
     *
     * @param delta The time in seconds since the last render.
     */
    public void update(float delta) {
        if (toastTimer != null) {
            toastTimer.update(delta);
        }
    }

    /**
     * Render body via {@link SpriteBatch}.
     *
     * @param spriteBatch The batch for drawing objects.
     */
    public void render(SpriteBatch spriteBatch) {
        if (toastMessage != null) {
            toastMessage.render(spriteBatch);
        }

        if (toastTimer != null) {
            toastTimer.render(spriteBatch);
        }
    }

    @Override
    public void dispose() {
        if (toastMessage != null) {
            toastMessage.dispose();
        }

        if (toastTimer != null) {
            toastTimer.dispose();
        }
    }

    /**
     * Build start toast.
     */
    private void buildStartToast() {
        BitmapFont bitmapFont = bitmapFontFactory.createFont(BitmapFontFactory.FontType.MESSAGE);
        toastMessage = new Toast(bitmapFont, MESSAGE_START_IN);
        toastMessage.setPositionY(Toast.PositionY.CENTER_ABOVE);
        toastMessage.setMarginY(MARGIN_Y_TOAST_MESSAGE);
    }

    /**
     * Build timer toast.
     */
    private void buildTimerToast(ToastTimerListener toastTimerListener) {
        BitmapFont bitmapFont = bitmapFontFactory.createFont(BitmapFontFactory.FontType.MESSAGE);
        toastTimer = new ToastTimer(bitmapFont);
        toastTimer.setPositionY(Toast.PositionY.CENTER_BELOW);
        toastTimer.setToastTimerListener(toastTimerListener);
        toastTimer.setMarginY(MARGIN_Y_TOAST_TIMER_MESSAGE);
    }
}
