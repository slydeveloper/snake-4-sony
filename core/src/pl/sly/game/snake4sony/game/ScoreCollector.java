package pl.sly.game.snake4sony.game;

import pl.sly.game.snake4sony.config.GameConfig;

/**
 * A class that represents mechanism for collecting score.
 */
public class ScoreCollector {

    private int score;

    /**
     * Increase score value.
     */
    public void addScore() {
        score += GameConfig.POINTS;
    }

    /**
     * Get score value.
     *
     * @return score value.
     */
    public int getScore() {
        return score;
    }

    /**
     * Reset score value.
     */
    public void reset() {
        score = 0;
    }
}
