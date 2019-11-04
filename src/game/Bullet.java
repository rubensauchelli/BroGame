package game;

import city.cs.engine.*;

public class Bullet extends DynamicBody {
    private SolidFixture fixture;
    //private static final Shape shape = new CircleShape(0.2f);
    private static final Shape shape = new PolygonShape(
            -1.11f,0.0f, -1.11f,-0.19f, 0.9f,-0.19f, 0.87f,0.01f);
    public static final BodyImage image =
            new BodyImage("data/bulletright.png", 4f);

    public Bullet(World world) {
        super(world);
        fixture = new SolidFixture(this,shape);
        fixture.setFriction(0);



        addImage(image);
        this.setName("bullet");


    }
}
