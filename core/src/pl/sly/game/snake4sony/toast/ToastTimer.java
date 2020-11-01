package pl.sly.game.snake4sony.toast;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * A class that represents timer type of the {@link Toast}
 */
public class ToastTimer extends Toast {

    private static final float DELAY = 1.0f;
    private static final int COUNT_INIT = 3;

    private float timeDelta = DELAY;
    private int count = COUNT_INIT;
    private ToastTimerListener toastTimerListener;

    /**
     * Constructor.
     *
     * @param bitmapFont The instance of {@link BitmapFont} for draw message.
     */
    public ToastTimer(BitmapFont bitmapFont) {
        super(bitmapFont);
    }

    /**
     * Set {@link ToastTimerListener} instance.
     *
     * @param toastTimerListener the {@link ToastTimerListener} instance.
     */
    public void setToastTimerListener(ToastTimerListener toastTimerListener) {
        this.toastTimerListener = toastTimerListener;
    }

    /**
     * Update toast between render.
     *
     * @param delta The time in seconds since the last render.
     */
    public void update(float delta) {
        timeDelta -= delta;
        if (timeDelta <= 0) {
            if (count <= 1) {
                count = COUNT_INIT;
                if (toastTimerListener != null) {
                    toastTimerListener.onTimeOut();
                }
            } else {
                count -= 1;
            }
            timeDelta = DELAY;
        }
        updateMessage(String.valueOf(count));
    }
}
