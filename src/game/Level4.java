package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Level 4 of the game
 */
public class Level4 extends GameLevel {

    private static final int NUM_KEYS = 1;
    private static final int NUM_COINS = 1;

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








        // make platforms
        Shape boxShape = new BoxShape(4, 0.25f);
        Shape boxShape2 = new BoxShape(10, 0.25f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(7, -8f));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(-5, -2.5f));
        Body platform3 = new StaticBody(this, boxShape2);
        platform3.setPosition(new Vec2(5, 5));
        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(-7, 0));
        Body platform5 = new StaticBody(this, boxShape);
        platform5.setPosition(new Vec2(5, -5));
        Body platform6 = new StaticBody(this, boxShape);
        platform6.setPosition(new Vec2(-15, -5));
        Body platform7 = new StaticBody(this, boxShape);
        platform7.setPosition(new Vec2(5, -15));
        Body platform8 = new StaticBody(this, boxShape);
        platform8.setPosition(new Vec2(-7, -10));



        //make flames
        for (int i = 0; i < 15; i++) {
            Body flames = new Flame(this);
            flames.setPosition(new Vec2(i*2-10, -12.3f));
            flames.addCollisionListener(new Burn(getPlayer1()));
            flames.addCollisionListener(new Burn(getPlayer2()));
        }



        // position of coins
        for (int i = 0; i < 10; i++) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i*2-10, 10));
            coin.addCollisionListener(new CoinPickup(getPlayer1()));
            coin.addCollisionListener(new CoinPickup(getPlayer2()));
        }
        // add key
        Body key = new Key(this);
        key.setPosition(new Vec2(-15, 10));
        key.addCollisionListener(new KeyPickup(getPlayer1()));
        key.addCollisionListener(new KeyPickup(getPlayer2()));




    }
    /**
     * set object positions
     */

    @Override
    public Vec2 startPositionP1() {
        return new Vec2(8, 15);
    }
    public Vec2 startPositionP2() {
        return new Vec2(10, 15);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(10.4f, -7f);
    }

    @Override
    public boolean isCompleted() {
        return
                ((getPlayer1().getKeyCount()+getPlayer2().getKeyCount())>=NUM_KEYS && (getPlayer1().getKeyCount()+getPlayer2().getKeyCount())>=NUM_KEYS );
    }
}
