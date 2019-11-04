package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 3 of the game
 */
public class Level3 extends GameLevel {

    private static final int NUM_COINS=5;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(40, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -21f));
        // walls
        Shape leftWallShape = new BoxShape(0.5f, 40, new Vec2(-19f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 40, new Vec2(19f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
        Shape wall1Shape = new BoxShape(0.5f, 20, new Vec2(-15f, 5.5f));
        Fixture wall1 = new SolidFixture(ground,wall1Shape );


        // make platforms
        Shape boxShape = new BoxShape(4, 0.25f);
        Shape boxShape2 = new BoxShape(10, 0.25f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, -8f));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(5, -2.5f));
        Body platform3 = new StaticBody(this, boxShape2);
        platform3.setPosition(new Vec2(-5, 5));
        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(7, 0));
        Body platform5 = new StaticBody(this, boxShape);
        platform5.setPosition(new Vec2(-5, -5));
        Body platform6 = new StaticBody(this, boxShape);
        platform6.setPosition(new Vec2(15, -5));
        Body platform7 = new StaticBody(this, boxShape);
        platform7.setPosition(new Vec2(-5, -15));
        Body platform8 = new StaticBody(this, boxShape);
        platform8.setPosition(new Vec2(7, -10));




        //private Brominator brominator;
        //brominator.setPosition(new Vec2(6,-8));
        //brominator.addCollisionListener(new BulletCollision(rambro,brominator));
        //make background fill




        //make flames
        for (int i = 0; i < 6; i++) {
            Body flames = new Flame(this);
            flames.setPosition(new Vec2(i*2-10, -19.25f));
            flames.addCollisionListener(new Burn(getPlayer1()));
            flames.addCollisionListener(new Burn(getPlayer2()));
        }



        // position of lives
        for (int i = 0; i < 10; i++) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i*2-10, 10));
            coin.addCollisionListener(new CoinPickup(getPlayer1()));
            coin.addCollisionListener(new CoinPickup(getPlayer2()));
        }
    }
    /**
     * set object positions
     */

    @Override
    public Vec2 startPositionP1() {
        return new Vec2(8, -10);
    }
    public Vec2 startPositionP2() {
        return new Vec2(10, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);
    }

    @Override
    public boolean isCompleted() {
        return (getPlayer1().getCoinCount()>=NUM_COINS||getPlayer2().getCoinCount()>=NUM_COINS);
    }
}
