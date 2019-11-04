package game;
import javax.swing.JFrame;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Key handler to control an Walker.
 */

//controls rambro

public class Controller1 extends KeyAdapter {

    private static final float JUMPING_SPEED = 20;
    private static final float WALKING_SPEED = 5;
    
    private Walker body;
    private GameLevel world;
    private Rambro rambro;
    private Brominator brominator;

    /** Sound */

    private SoundClip shootSound;



    public Controller1(Walker body, GameLevel world) {



        this.body = body;
        this.world = world;
    }
    private BodyImage runLeft = new BodyImage("data/Rambro/RambroMotionLeft.gif", 2.25f);
    private BodyImage runRight = new BodyImage("data/Rambro/RambroMotionRight.gif", 2.25f);
    private BodyImage standLeft = new BodyImage("data/Rambro/RambroLeft.png", 2.25f);
    private BodyImage standRight = new BodyImage("data/Rambro/RambroRight.png", 2.25f);
    private boolean isFacingLeft = true;
    //direction to shoot
    public void pointLeft() {
        isFacingLeft = true;
        //System.out.println("Rambro pointing Left" );
    }
    public void pointRight() {
        isFacingLeft = false;
        //System.out.println("Rambro pointing Right" );
    }
    public void shootSound() {

            try {
                shootSound = new SoundClip("data/Shot1.wav");
                shootSound.play();
            }
            catch (UnsupportedAudioFileException | IOException | LineUnavailableException event){
                System.out.println("Sound Error: " + event);
            }

    }

    //Bullet object
    // for Rambro
    public void bulletShootRight(int velocity, int playerPos){
        Bullet bullet =new Bullet(world);
        bullet.setBullet(true);
        bullet.addCollisionListener(new BulletCollision(rambro,brominator));
        bullet.setPosition(new Vec2(body.getPosition().x - playerPos, body.getPosition().y));
        bullet.setLinearVelocity(new Vec2(-velocity,0));
        shootSound();
    }
    public void bulletShootLeft(int velocity, int playerPos){
        Bullet bullet =new Bullet(world);
        bullet.setBullet(true);
        //bullet.addCollisionListener(new BulletCollision(bullet));
        bullet.addCollisionListener(new BulletCollision(rambro,brominator));
        bullet.setPosition(new Vec2(body.getPosition().x + playerPos, body.getPosition().y));
        bullet.setLinearVelocity(new Vec2(velocity,0));
        shootSound();
    }


    /**
     * Handle key press events for walking and jumping and shooting.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_W) { // W = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.setGravityScale(4);
                body.jump(JUMPING_SPEED);



            }
            /*else if (code == KeyEvent.VK_X) { // X = Shoot
                Vec2 bv = body.getLinearVelocity();
                // only jump if body is not already jumping
                if (Math.abs(bv.y) < 0.01f) {
                    body.setGravityScale(4);
                    body.jump(JUMPING_SPEED);


                }*/
        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED); // A = walk left
            body.removeAllImages();
            body.addImage(runLeft);
            pointLeft();


        } else if (code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED);// D = walk right
            body.removeAllImages();
            body.addImage(runRight);


            pointRight();

        }
        else if (code == KeyEvent.VK_X) { // X = Shoot
            if(isFacingLeft){
                bulletShootRight(30, 2);
                body.setLinearVelocity(new Vec2(0, 0));
            }
            else if(!isFacingLeft){
                bulletShootLeft(30, 2);
                body.setLinearVelocity(new Vec2(0, 0));
               // body.addCollisionListener(new BulletCollision(body));

            }


        }
    }



    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
            body.removeAllImages();
           body.addImage(standLeft);
            pointLeft();

        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
            body.removeAllImages();
           body.addImage(standRight);
            pointRight();
        }
    }
    public void setBody(Walker body) {
        this.body = body;
    }
}
