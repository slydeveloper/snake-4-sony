package pl.sly.game.snake4sony.asset;

/**
 * Graphics asset enum.
 */
public enum GfxAsset {

    BODY("body.png"),
    FOOD("food.png");

    GfxAsset(String path) {
        this.path = PREFIX + path;
    }

    public String getPath() {
        return path;
    }

    private static final String PREFIX = "gfx/";
    private String path;
}
