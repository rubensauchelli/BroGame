package game;

import city.cs.engine.*;


/**
 * A life.
 */
public class Key extends DynamicBody {
    //private static final Shape shape = new CircleShape(0.2f);
    private static final Shape shape = new PolygonShape(
            -0.928f,0.82f, -0.95f,-0.984f, 0.95f,-0.98f, 0.942f,0.833f);
    public static final BodyImage image =
            new BodyImage("data/pixelkey.gif", 1.5f);

    public Key(World world) {
        super(world, shape);

        addImage(image);

    }

}
