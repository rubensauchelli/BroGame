package game;
import city.cs.engine.*;
import javax.swing.JFrame;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class Brominator extends Walker{
    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.12f,1.107f, -1.052f,-0.288f, -1.047f,-0.891f, -0.368f,-1.102f, 0.82f,-1.107f, 1.045f,-0.414f, 1.041f,0.333f, 0.348f,1.107f);

    public static final BodyImage image =
            new BodyImage("data/Brominator.png", 2.25f);

    private int livesCount;
    private int keyCount;
    private int coinCount;


    /** Sound */
    private SoundClip pickupSound;
    private SoundClip hurtSound;

    public Brominator(World world) {
        super(world, shape);
        addImage(image);
        livesCount = 3;
        keyCount = 0;
        coinCount=0;

        this.setName("Brominator");


    }

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
        System.out.println("Hurray!  Brominator lives = " + livesCount);
    }
    public void setCoinCount(int coins){
        coinCount=coins;
    }
    public void setLivesCount(int lives){
        livesCount=lives;
    }
    public void decreaseLivesCount() {
        livesCount--;
        hurtSound();
        System.out.println("Ooops !  Brominator lives = " + livesCount);
    }
    public void incrementKeyCount() {
        keyCount++;
        pickupSound();

    }
    public void decreaseKeyCount() {
        keyCount--;

    }
    public void incrementCoin() {
        coinCount++;
        pickupSound();
        System.out.println("Rambo ammo = " + coinCount);
    }
}
