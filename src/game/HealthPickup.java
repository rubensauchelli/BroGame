package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the players to collect things.
 */
public class HealthPickup implements CollisionListener {
    private Rambro rambro;
    private Brominator brominator;
    
    public HealthPickup(Rambro rambro) {
        this.rambro = rambro;
    }
    public HealthPickup(Brominator brominator) {
        this.brominator = brominator;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == rambro) {
            rambro.incrementLivesCount();
            e.getReportingBody().destroy();
        }
        else if (e.getOtherBody() == brominator) {
            brominator.incrementLivesCount();
            e.getReportingBody().destroy();
        }
    }






    
}

