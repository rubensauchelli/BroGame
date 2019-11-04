package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class KeyPickup implements CollisionListener {
    private Rambro rambro;
    private Brominator brominator;

    public KeyPickup(Rambro rambro) {
        this.rambro = rambro;
    }
    public KeyPickup(Brominator brominator) {
        this.brominator = brominator;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == rambro) {
            rambro.incrementKeyCount();
            e.getReportingBody().destroy();
        }
        else if (e.getOtherBody() == brominator) {
            brominator.incrementKeyCount();
            e.getReportingBody().destroy();
        }

    }
}
