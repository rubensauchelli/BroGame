package game;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.RescaleOp;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import city.cs.engine.*;
import java.util.Timer;
import java.util.TimerTask;


/**
 * extended view
 */
public class MyView extends UserView {
    Brominator brominator;
    Rambro rambro;
    
    //private Image background;
    private Image bannerRambro;
    private Image bannerBrominator;
    private Image hearts;
    private Image coin;
    private Image[] background = new Image[4];
    private int levels;
    private ArrayList<Image>checkImage = new ArrayList<>();

    public int secondsPassed = 0;
    Timer myTimer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsPassed++;

            System.out.println("seconds passed" +
                    + secondsPassed);
            if (secondsPassed > 300){
                System.exit(0);
            }

        }

    };


    public MyView(World world,Rambro rambro, Brominator brominator, int width, int height) {
        super(world, width, height);
        this.brominator = brominator;
        this.rambro = rambro;
        //this.background = new ImageIcon("data/city.gif").getImage();
        this.bannerRambro = new ImageIcon("data/Rambro/RambroBanner.png").getImage();
        this.bannerBrominator = new ImageIcon("data/BrominatorBanner.png").getImage();
        this.hearts = new ImageIcon("data/smallhearts.gif").getImage();
        this.coin = new ImageIcon("data/coin.gif").getImage();


        //this.background = new ImageIcon("data/city.gif").getImage();
        background[0] = new ImageIcon("data/city.gif").getImage();
        background[1] = new ImageIcon("data/level2.gif").getImage();
        background[2] = new ImageIcon("data/level3.gif").getImage();
        background[3] = new ImageIcon("data/level4.gif").getImage();
        //if (levels==1){
            myTimer.scheduleAtFixedRate(task,1000,1000);
        //}


    }


    
    @Override
    protected void paintBackground(Graphics2D g) {
        //g.drawImage(background, 0, 0, this);

        levels = Game.getLevel();
        if(levels == 1){
            g.drawImage(background[0], 0, 0,750,850, this);

        }
        else if(levels == 2){
            g.drawImage(background[1], 0, 0,750,850, this);
        }
        else if(levels == 3){
            g.drawImage(background[2], 0, 0,750,850, this);

        }
        if(levels == 4){
            g.drawImage(background[3], 0, 0,750,850, this);
       }

    }

    @Override
    protected void paintForeground(Graphics2D g) {

        g.drawImage(bannerRambro, 0, 0, this);

        for (int i=0;i<rambro.getLivesCount();i++){
            g.drawImage(hearts, 75+i*40, 75, this);

        }

        //g.setColor(Color.white);
        g.setFont(new Font("Helvetica",Font.BOLD,20));
        g.drawString("KEYS:" + rambro.getKeyCount()    , 80,20);
        g.drawImage(coin, 60, 10, this);
        g.drawString("    " + rambro.getCoinCount()    , 80,45);

        //g.drawString("AMMO:"    , 100,70);

        g.drawImage(bannerBrominator, 671, 0, this);
        if (levels==1){
            g.drawString("TIMER:" + secondsPassed    , 350,50);
            g.drawString("YOU HAVE 45 SECONDS"   , 250,70);

        }
        else if (levels==2){

            g.drawString("COLLECT THE KEY"   , 250,70);
        }
        else if (levels==3){

            g.drawString("COLLECT 5 COINS"   , 250,70);
        }
        else if (levels==4){

            g.drawString("COLLECT 5 COINS AND THE KEY"   , 200,70);
        }



        for (int i=0;i<brominator.getLivesCount();i++){
            g.drawImage(hearts, 640-i*40, 75, this);

        }
        g.drawString("KEYS:"   + brominator.getKeyCount() , 600,20);

        g.drawImage(coin, 630, 10, this);
        g.drawString("     "   + brominator.getCoinCount() , 600,45);

    }


}
