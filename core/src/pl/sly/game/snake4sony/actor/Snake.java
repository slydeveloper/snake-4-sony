package pl.sly.game.snake4sony.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pl.sly.game.snake4sony.actor.base.BaseActor;
import pl.sly.game.snake4sony.actor.model.Body;
import pl.sly.game.snake4sony.actor.model.Head;
import pl.sly.game.snake4sony.asset.GfxAsset;
import pl.sly.game.snake4sony.config.GameConfig;
import pl.sly.game.snake4sony.type.DirectionType;

/**
 * A class that represents the snake actor.
 */
public class Snake extends BaseActor {

    private Texture texture;
    private LinkedList<Body> bodyList;
    private DirectionType directionType;
    private Head head;

    /**
     * Constructor.
     */
    public Snake() {
        texture = new Texture(GfxAsset.BODY.getPath());
        bodyList = new LinkedList<>();
    }

    /**
     * Reset Snake position and direction.
     */
    public void reset() {
        bodyList.clear();

        for (int i = GameConfig.SNAKE_BODY_INIT - 1; i >= 0; i--) {
            Vector2 position = new Vector2(i, 0);
            extendBody(position);
        }

        directionType = DirectionType.RIGHT;
        head = new Head(bodyList.getFirst(), directionType);
    }

    /**
     * Move the snake. First move body, next move head.
     */
    public void move() {
        moveBody();
        moveHead();
    }

    /**
     * Crash the snake. Set a fog effect for entire {@link Body} elements.
     */
    public void crash() {
        for (int i = bodyList.size() - 1; i > 0; i--) {
            Body body = bodyList.get(i);
            body.fog();
        }
    }

    /**
     * Return list of {@link Head} and {@link Body} items positions.
     *
     * @return List of {@link Vector2} positions.
     */
    public List<Vector2> getAllBodyPositionList() {
        List<Vector2> vectorList = new ArrayList<>();
        for (Body body : bodyList) {
            vectorList.add(body.getPosition());
        }
        return vectorList;
    }

    /**
     * Update snake {@link DirectionType}.
     *
     * @param directionType The snake {@link DirectionType}.
     */
    public void updateDirection(DirectionType directionType) {
        this.directionType = directionType;
    }

    /**
     * Check if snake has collision with {@link Food} position.
     *
     * @param foodPosition The {@link Food} position as {@link Vector2}.
     * @return true/false if collision with {@link Food}.
     */
    public boolean isFoodCollision(Vector2 foodPosition) {
        return getAllBodyPositionList().contains(foodPosition);
    }

    /**
     * Check if snake has self collision.
     *
     * @return true/false if snake has self collision.
     */
    public boolean isBodyCollision() {
        return getOnlyBodyPositionList().contains(head.getPosition());
    }

    /**
     * Expand snake starts for the tail.
     */
    public void expand() {
        Body tail = bodyList.getLast();
        extendBody(tail.getPosition());
    }

    @Override
    public void render(SpriteBatch batch) {
        for (Body body : bodyList) {
            body.render(batch);
        }
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    /**
     * Add new {@link Body} to the snake.
     *
     * @param position The position of the new {@link Body}.
     */
    private void extendBody(Vector2 position) {
        Body body = new Body(texture, position);
        bodyList.add(body);
    }

    /**
     * Move {@link Body} elements.
     * Iterate over {@link Body} elements and replace positions one by one.
     */
    private void moveBody() {
        for (int i = bodyList.size() - 1; i > 0; i--) {
            Body currentBody = bodyList.get(i);
            Body nextBody = bodyList.get(i - 1);
            currentBody.updatePosition(nextBody.getPosition());
        }
    }

    /**
     * Move {@link Head} based on the {@link DirectionType}.
     */
    private void moveHead() {
        head.updateDirection(directionType);
    }

    /**
     * Return only {@link Body} positions, without {@link Head}.
     *
     * @return List of {@link Vector2} positions.
     */
    private List<Vector2> getOnlyBodyPositionList() {
        List<Vector2> vectorList = getAllBodyPositionList();
        vectorList.remove(0);

        return vectorList;
    }
}