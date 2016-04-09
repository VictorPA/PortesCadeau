package doors;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Victor on 08/04/2016.
 */
public class PlayerDoorChanging extends Player {

    @Override
    public void end(ArrayList<Door> doors) {
        super.end(doors);

        for (Door d : doors) {
            if (d.isChosen())
                this.closedDoors.remove(d);
        }
        Random rand = new Random();
        int randomNum = rand.nextInt(closedDoors.size());


        //Door picking
        this.closedDoors.get(randomNum).choose();

        for(Door d : this.closedDoors){
            if(d.isGifted()&&d.isChosen())
                this.score++;
        }



    }
}
