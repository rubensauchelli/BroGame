package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Collision listener that allows the players to collect things.
 */
public class CoinPickup implements CollisionListener {
    private Rambro rambro;
    private Brominator brominator;

    public CoinPickup(Rambro rambro) {
        this.rambro = rambro;
    }
    public CoinPickup(Brominator brominator) {
        this.brominator = brominator;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == rambro) {
            rambro.incrementCoin();
            e.getReportingBody().destroy();
        }
        else if (e.getOtherBody() == brominator) {
            brominator.incrementCoin();
            e.getReportingBody().destroy();
        }
    }






    
}

