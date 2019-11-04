package game;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class HighScoreReader {
    private String fileName;
    public int tLevel;
    public int tScore;
    public int tLife;

    /**
     * Initialise a new HighScoreReader
     * @param fileName the name of the high-score file
     */
    public HighScoreReader(String fileName) {
        this.fileName = fileName;

    }

    /**
     * Read the high-score data from the high-score file and print it to
     * the terminal window.
     */
    public void readScores() throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                // file is assumed to contain one name, score pair per line
                String[] tokens = line.split(",");
                int level = Integer.parseInt(tokens[0]);
                tLevel = level;
                int score = Integer.parseInt(tokens[1]);
                tScore = score;
                int life = Integer.parseInt(tokens[2]);
                tLife = life;

                System.out.println("Level: " + level + ", Coins: " + score + ", Life: " + life);
                line = reader.readLine();
            }
            System.out.println("...done.");
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }

    public int getTestLevel(){
        return tLevel;
    }

    public int getTestScore(){
        return tScore;
    }

    public int getTestLife(){
        return tLife;
    }

    public static void main(String[] args) throws IOException {
        HighScoreReader demo = new HighScoreReader(args[1]);
        demo.readScores();
    }
}
