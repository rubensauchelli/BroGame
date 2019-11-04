package game;

import city.cs.engine.*;

import java.awt.*;
import java.io.IOException;
import java.util.List;


import javax.swing.JFrame;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.jbox2d.common.Vec2;



/**
 * The computer game.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;
    private static int level;



    private Controller1 controller1;
    private Controller2 controller2;

    /** Sound */
    private SoundClip gameMusic;

    /** The World in which the bodies move and interact. */



    /** Initialise a new Game. */
    public Game() {

        //final BodyImage image =
        //        new BodyImage("data/city.png", 2.25f);


        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);
        //world = new GameWorld();
        //world size
        view = new MyView(world,world.getPlayer1(), world.getPlayer2(), 750, 850);
       // view.setZoom(30);
       // view.imageUpdate(image,0,0,0,10,10);

        // make a view
        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame

        //define sound


            try {
                gameMusic = new SoundClip("data/music.wav");
                gameMusic.loop();

            }
            catch (UnsupportedAudioFileException | IOException | LineUnavailableException event2){
                System.out.println("Sound Error:" + event2);
            }


        final JFrame frame = new JFrame("Event handling");

        ControlPanel buttons = new ControlPanel(this);
        frame.add(buttons.getMainPanel(), BorderLayout.SOUTH);

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        
        
        
        
       // frame.addKeyListener(new Controller1(world.getPlayer1()));
        //frame.addKeyListener(new Controller2(world.getPlayer2()));


        // uncomment to make the view track the bird
        // world.addStepListener(new Tracker(view, world.getPlayer()));

        // uncomment this to make a debugging view
         //JFrame debugView = new DebugViewer(world, 500, 500);
        controller1 = new Controller1(world.getPlayer1(), world);
        frame.addKeyListener(controller1);
        controller2 = new Controller2(world.getPlayer2(),world);
        frame.addKeyListener(controller2);
        // start!
        world.start();
    }
    /** The players in the current level. */
    public Rambro getPlayer1() {
        return world.getPlayer1();
    }
    public Brominator getPlayer2() {

        return world.getPlayer2();
    }

    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /** Advance to the next level of the game. */
    public void goNextLevel() {
        world.stop();
        if (level == 4) {
            System.exit(0);
        } else if(level == 1){
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller1.setBody(world.getPlayer1());
            controller2.setBody(world.getPlayer2());
            view = new MyView(world,world.getPlayer1(), world.getPlayer2(), 750, 850);
            // show the new world in the view
            view.setWorld(world);

            world.start();
        }
        else if(level == 2){
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller1.setBody(world.getPlayer1());
            controller2.setBody(world.getPlayer2());
            // show the new world in the view
            view.setWorld(world);
            view = new MyView(world,world.getPlayer1(), world.getPlayer2(), 750, 850);

            world.start();
        }
        else if(level == 3){
            level++;
            // get a new world
            world = new Level4();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller1.setBody(world.getPlayer1());
            controller2.setBody(world.getPlayer2());
            // show the new world in the view
            view.setWorld(world);

            world.start();
        }
    }
    //action to load Level 1
    public void goToLevel1() {
        level =1;
        world=new Level1();
        world.populate(this);
        view.setWorld(world);
        controller1.setBody(world.getPlayer1());
        controller2.setBody(world.getPlayer2());
        world.start();

    }

    //action to load Level 2
    public void goToLevel2() {
        level =2;
        world=new Level2();
        world.populate(this);
        view.setWorld(world);
        controller1.setBody(world.getPlayer1());
        controller2.setBody(world.getPlayer2());
        world.start();

    }
    //action to load Level 3
    public void goToLevel3() {
        level =3;
        world=new Level3();
        world.populate(this);
        view.setWorld(world);
        controller1.setBody(world.getPlayer1());
        controller2.setBody(world.getPlayer2());
        world.start();


    }
    //action to load Level 4
    public void goToLevel4() {
        level =4;
        world=new Level4();
        world.populate(this);
        view.setWorld(world);
        controller1.setBody(world.getPlayer1());
        controller2.setBody(world.getPlayer2());
        world.start();


    }
    public void setReader(){
        try {
            HighScoreReader reader = new HighScoreReader("data/save.txt");
            reader.readScores();
            int coins = reader.getTestScore();
            world.getPlayer1().setCoinCount(coins);
            int lives = reader.getTestLife();
            world.getPlayer1().setLivesCount(lives);
            level = reader.getTestLevel()-1;

            goNextLevel();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setWriter(){
        try {
            HighScoreWriter writer = new HighScoreWriter("data/save.txt");
            writer.writeHighScore(level, world.getPlayer1().getCoinCount(), world.getPlayer1().getLivesCount());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static int getLevel() {
       return level;
    }

    //start game music
    public void playMusic() {
       gameMusic.play();

    }
    //stop game music
    public void stopMusic() {
        gameMusic.stop();

    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
     
        
    }

    public GameLevel getWorld() {
        return world;
    }

    public void pause() {
        world.stop();
    }

    public void resume() {
        world.start();
    }
    public void restart() {
        new Game();
    }
}
