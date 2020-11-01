package pl.sly.game.snake4sony.input;

import com.badlogic.gdx.input.GestureDetector;

/**
 * A class that represents detector for handling touch screen gestures.
 */
public class SwipeHandler extends GestureDetector {

    /**
     * Constructor.
     *
     * @param directionListener The {@link DirectionListener} for handling input.
     */
    public SwipeHandler(DirectionListener directionListener) {
        super(new SwipeGestureAdapter(directionListener));
    }

    /**
     * A class that represents {@link GestureAdapter}.
     */
    private static class SwipeGestureAdapter extends GestureAdapter {

        private DirectionListener directionListener;

        /**
         * Constructor.
         *
         * @param directionListener The {@link DirectionListener} for handling input.
         */
        public SwipeGestureAdapter(DirectionListener directionListener) {
            this.directionListener = directionListener;
        }

        @Override
        public boolean fling(float velocityX, float velocityY, int button) {
            if (Math.abs(velocityX) > Math.abs(velocityY)) {
                if (velocityX > 0) {
                    directionListener.onRight();
                } else {
                    directionListener.onLeft();
                }
            } else {
                if (velocityY > 0) {
                    directionListener.onDown();
                } else {
                    directionListener.onUp();
                }
            }
            return super.fling(velocityX, velocityY, button);
        }
    }
}
