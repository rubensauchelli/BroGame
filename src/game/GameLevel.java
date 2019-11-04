package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    private Rambro player1;
    private Brominator player2;
    
    public Rambro getPlayer1() {
        return player1;
    }
    public Brominator getPlayer2() {
        return player2;
    }
    
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {
        // make a Rambro character
        player1 = new Rambro(this);
        player1.setPosition(startPositionP1());
        // make a Brominator character
        player2 = new Brominator(this);
        player2.setPosition(startPositionP2());
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));
        //player1.addCollisionListener(new BulletCollision(player1,player2));
    }
    
    /** The initial position of the player. */
    public abstract Vec2 startPositionP1();
    public abstract Vec2 startPositionP2();
    /** The position of the exit door. */
    public abstract Vec2 doorPosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();
}
