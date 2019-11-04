package game;

import city.cs.engine.*;
import javax.swing.JFrame;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/**
 * Rambro
 */
public class Rambro extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance. 
    // That means there is a single shape and image for all instances of the class.

    //checking direction


    private static final Shape shapeLeft = new PolygonShape(
            -0.237f,1.116f, -0.836f,0.288f, -0.84f,-0.396f, -0.597f,-1.107f, 0.591f,-1.098f, 0.694f,0.284f, 0.343f,1.107f);

    public static final BodyImage image =
        new BodyImage("data/Rambro/RambroLeft.png", 2.25f);




    private int livesCount;

    private int keyCount;
    private int coinCount;

    /** Sound */
    private SoundClip pickupSound;
    private SoundClip hurtSound;

    public void hurtSound() {

        try {
            hurtSound = new SoundClip("data/lifelost.wav");
            hurtSound.play();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException event){
            System.out.println("Sound Error: " + event);
        }

    }
    public void pickupSound() {

        try {
            pickupSound = new SoundClip("data/collect.wav");
            pickupSound.play();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException event){
            System.out.println("Sound Error: " + event);
        }

    }





    public Rambro(World world) {

        super(world, shapeLeft);

        addImage(image);
        livesCount = 3;

        keyCount = 0;
        coinCount = 0;







    }

    public int getLivesCount() {
        return livesCount;
    }
    public int getKeyCount() {
        return keyCount;
    }
    public int getCoinCount() {
        return coinCount;
    }




    public void incrementLivesCount() {
        livesCount++;
        pickupSound();
        System.out.println("Hurray!  Rambo lives = " + livesCount);
    }
    public void decreaseLivesCount() {
        livesCount--;
        hurtSound();
        System.out.println("Ooops !  Rambo lives = " + livesCount);
    }
    public void incrementKeyCount() {
        keyCount++;
        pickupSound();

    }
    public void decreaseKeyCount() {
        keyCount--;

    }
    public void setCoinCount(int coins){
        coinCount=coins;
    }
    public void setLivesCount(int lives){
        livesCount=lives;
    }

    public void incrementCoin() {
        coinCount++;
        pickupSound();
        System.out.println("Rambo ammo = " + getCoinCount());
    }

}
