package pl.sly.game.snake4sony.asset;

/**
 * Font asset enum.
 */
public enum FontAsset {

    PIXEL("pixel.ttf");

    FontAsset(String path) {
        this.path = PREFIX + path;
    }

    public String getPath() {
        return path;
    }

    private static final String PREFIX = "font/";
    private String path;
}
