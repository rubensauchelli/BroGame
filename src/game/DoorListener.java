package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level. 
 */
public class DoorListener implements CollisionListener {
    private Game game;
    
    public DoorListener(Game game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        Rambro player1 = game.getPlayer1();
        Brominator player2 = game.getPlayer2();
        if (e.getOtherBody() == player1 && game.isCurrentLevelCompleted()) {
            System.out.println("Rambro completes level");
            System.out.println();
            game.goNextLevel();
        }
        else if (e.getOtherBody() == player2 && game.isCurrentLevelCompleted()) {
            System.out.println("Brominator completes level");
            game.goNextLevel();
        }
    }
}
