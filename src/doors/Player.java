package doors;

import java.util.ArrayList;

/**
 * Created by Victor on 08/04/2016.
 */
public abstract class Player {

    protected int score;
    protected ArrayList<Door> closedDoors = null;

    public Player() {
        this.score = 0;
    }

    public void win() {
        this.score++;
    }

    public void end(ArrayList<Door> doors) {

        closedDoors = new ArrayList<>();
        for (Door d : doors) {
            if (!d.isOpened())
                closedDoors.add(d);
        }




    }
}
