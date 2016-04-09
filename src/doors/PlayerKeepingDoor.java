package doors;

import java.util.ArrayList;

/**
 * Created by Victor on 08/04/2016.
 */
public class PlayerKeepingDoor extends Player {

    @Override
    public void end(ArrayList<Door> doors) {
        super.end(doors);
        for(Door d : this.closedDoors){
            if(d.isGifted()&&d.isChosen())
                this.score++;
        }

    }
}
