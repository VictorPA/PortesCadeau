package doors;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Victor on 08/04/2016.
 */
public class Game {

    IPlayerFactory playerFactory;

    Room room;
    Player player;
    int simulationsNumber;

    public Game(IPlayerFactory playerFactory) {
        this.playerFactory = playerFactory;
    }

    public void send(int gamesInput, int doorsInput, int playerInput) {


        player = playerFactory.choosePlayer(playerInput);
        room = new Room(doorsInput);
        ArrayList<Door> doors = room.getDoors();
        int doorNumbers = doors.size();
        int n;
       // long startTime = System.nanoTime();


        for (n = 0; n < gamesInput; ++n) {
            room.resetRoom();
            Random rand = new Random();
            int randomNum = rand.nextInt(doorNumbers);

            //Door picking
            doors.get(randomNum).choose();

            //
            int x = -1;

            for (int i = 0; i < doors.size(); ++i) {
                if (doors.get(i).isChosen() && doors.get(i).isGifted()) {
                    x = i;
                    continue;
                } else if (doors.get(i).isChosen() || doors.get(i).isGifted()) {
                    continue;
                }
                doors.get(i).open();

            }
            if (x != -1) {
                if (x == 0)
                    doors.get(1).close();
                else if (x == doors.size() - 1)
                    doors.get(doors.size() - 2).close();
                else
                    doors.get(x - 1).close();
            }


            player.end(doors);


        }
        this.simulationsNumber = n;
        //long endTime = System.nanoTime();

        //System.out.println((endTime - startTime)/1000000);

    }

    public int getDoorsNumber() {
        return this.simulationsNumber;
    }

    public int getResult() {
        return this.player.getScore();
    }
}
