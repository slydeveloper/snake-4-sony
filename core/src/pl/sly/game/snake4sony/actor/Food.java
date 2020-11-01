package pl.sly.game.snake4sony.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.sly.game.snake4sony.actor.base.BaseActor;
import pl.sly.game.snake4sony.actor.model.Body;
import pl.sly.game.snake4sony.asset.GfxAsset;
import pl.sly.game.snake4sony.config.GameConfig;

/**
 * A class that represents food game actor.
 * Food is collected by the Snake.
 */
public class Food extends BaseActor {

    private Texture texture;
    private Sprite sprite;
    private Vector2 position;
    private Random random;

    /**
     * Constructor.
     */
    public Food() {
        texture = new Texture(GfxAsset.FOOD.getPath());
        sprite = new Sprite(texture);
        sprite.setSize(GameConfig.FOOD_CELL_SIZE, GameConfig.FOOD_CELL_SIZE);
        random = new Random();
        setVisible(false);
    }

    /**
     * Get {@link Vector2} position of the head.
     *
     * @return {@link Vector2} position of the head.
     */
    public Vector2 getPosition() {
        return position;
    }

    /**
     * Reset food position. Call after collect food or reset game.
     *
     * @param bodyPositionList The list of body {@link Vector2} positions.
     */
    public void reset(List<Vector2> bodyPositionList) {
        setVisible(true);
        position = generatePosition(bodyPositionList);
        float posX = GameConfig.FOOD_START_X + GameConfig.FOOD_CELL_SIZE * position.x;
        float posY = GameConfig.FOOD_START_Y + GameConfig.FOOD_CELL_SIZE * position.y;
        sprite.setPosition(posX, posY);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        if (isVisible()) {
            sprite.draw(spriteBatch);
        }
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    /**
     * Generate food position. It skips {@link Body} {@link Vector2} positions for avoid collision.
     *
     * @param bodyPositionList The list of body {@link Vector2} positions.
     * @return {@link Vector2} of food position.
     */
    private Vector2 generatePosition(List<Vector2> bodyPositionList) {
        List<Vector2> positionList = generateEvenPositionList();
        positionList.removeAll(bodyPositionList);
        Vector2 position = positionList.get(random.nextInt(positionList.size()));

        return position;
    }

    /**
     * Generate only even {@link Vector2#x} + {@link Vector2#y} positions.
     * Will be used for set {@link Food} position.
     *
     * @return list of {@link Vector2} positions.
     */
    private List<Vector2> generateEvenPositionList() {
        List<Vector2> positionList = new ArrayList<>();

        for (int posX = 0; posX < GameConfig.BOARD_WIDTH; posX++) {
            for (int posY = 0; posY < GameConfig.BOARD_HEIGHT; posY++) {
                if ((posY + posX) % 2 == 0) {
                    positionList.add(new Vector2(posX, posY));
                }
            }
        }

        return positionList;
    }
}
