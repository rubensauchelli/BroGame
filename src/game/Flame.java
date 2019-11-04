package game;
import city.cs.engine.*;

public class Flame extends DynamicBody{
    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            0.212f,-1.098f, 0.617f,-0.616f, 0.603f,-0.054f, -0.702f,-0.058f, -0.711f,-0.733f, -0.513f,-1.111f);

    public static final BodyImage image =
            new BodyImage("data/flame.gif", 2.25f);



    public Flame(World world) {
        super(world, shape);
        addImage(image);
        setName("FLAMES");
        ;


    }




}

