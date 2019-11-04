//package game;

//import city.cs.engine.*;
//import org.jbox2d.common.Vec2;

/**
 *
 * @author greg
 */

/**
 * A world with some bodies.
 */
/*public class GameWorld extends World {
    private Rambro rambro;
    private Brominator brominator;
    private Bullet bullet;



    public GameWorld() {
        super();
        
        // make the ground
        Shape groundShape = new BoxShape(13, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -14f));
        // walls
        Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-13f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(13f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
        

        // make platforms
        Shape boxShape = new BoxShape(4, 0.25f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, -8f));
        //Body platform2 = new StaticBody(this, boxShape);
       // platform2.setPosition(new Vec2(5, -2.5f));

        //make background fill


        // make a Rambro character
        rambro = new Rambro(this);
        rambro.setPosition(new Vec2(8, -10));
        //rambro.addCollisionListener(new BulletCollision(rambro));

        //make a Brominator character
        brominator = new Brominator(this);
        brominator.setPosition(new Vec2(10, -10));
        //brominator.addCollisionListener(new BulletCollision(bullet));
       // bullet.addCollisionListener(new BulletCollision(brominator));
        //make flames
        for (int i = 0; i < 6; i++) {
            Body flames = new Flame(this);
            flames.setPosition(new Vec2(i*2-10, -12.3f));
            flames.addCollisionListener(new Burn(rambro));
            flames.addCollisionListener(new Burn(brominator));
        }



        // position of lives
        for (int i = 0; i < 4; i++) {
            Body life = new Life(this);
            life.setPosition(new Vec2(i*2-10, 10));
            life.addCollisionListener(new HealthPickup(rambro));
            life.addCollisionListener(new HealthPickup(brominator));
        }
       // Body bullet = new Bullet(this);
    }
    
    public Rambro getPlayer1() {
        return rambro;
    }
    public Brominator getPlayer2() {
        return brominator;
    }


}*/
