package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the players to collect things.
 */
public class Burn implements CollisionListener {
    private Rambro rambro;
    private Brominator brominator;

    public Burn(Rambro rambro) {
        this.rambro = rambro;
    }
    public Burn(Brominator brominator) {
        this.brominator = brominator;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == rambro) {
            rambro.decreaseLivesCount();
            e.getReportingBody().destroy();
            if (rambro.getLivesCount()==0){
                e.getOtherBody().destroy();
                System.out.println("Rambro died");
            }
        }
        else if (e.getOtherBody() == brominator) {
            brominator.decreaseLivesCount();
            e.getReportingBody().destroy();
            if (brominator.getLivesCount()==0){
                e.getOtherBody().destroy();
                System.out.println("Brominator died");
            }
        }
    }






}