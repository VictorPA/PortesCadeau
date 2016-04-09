package doors;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Victor on 08/04/2016.
 */
public class Room {

    private ArrayList<Door> doors;
    private Random rand;


    public Room(int doorNumber) {
        rand = new Random();
        doors = new ArrayList<>();
        int randomNum = rand.nextInt(doorNumber);


        for (int i = 0; i < doorNumber; ++i) {
            doors.add(new Door("door" + i));


        }
        doors.get(randomNum).gift();


    }

    public void resetRoom(){

        for(Door d : doors){
            d.resetDoor();
        }
        int randomNum = rand.nextInt(doors.size());
        doors.get(randomNum).gift();
    }

    public ArrayList<Door> getDoors(){
        return this.doors;
    }

}
