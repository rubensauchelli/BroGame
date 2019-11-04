package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the Players to collect things.
 */
public class BulletCollision implements CollisionListener {
    private Rambro rambro;
    private Brominator brominator;


    public BulletCollision(Rambro rambro,Brominator brominator) {
        this.rambro = rambro;
        this.brominator = brominator;

    }


    @Override
    public void collide(CollisionEvent e) {


        if (e.getReportingBody().getName() == "bullet"){
            String itemHit = e.getOtherBody().getName();
            System.out.println(itemHit);

            if (e.getOtherBody().getName()=="Brominator"){

                System.out.println("Brominator hit");
                //System.out.println(brominator.getLivesCount());
            }
            e.getReportingBody().destroy();
            System.out.println("bullet hit");
        }


    }
}
