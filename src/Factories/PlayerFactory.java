package Factories;

import doors.IPlayerFactory;
import doors.Player;
import doors.PlayerDoorChanging;
import doors.PlayerKeepingDoor;

/**
 * Created by Victor on 10/04/2016.
 */
public class PlayerFactory implements IPlayerFactory {

    @Override
    public Player choosePlayer(int playerInput) {
        Player player = null;
        if (playerInput == 0)
            player = new PlayerKeepingDoor();
        if (playerInput == 1)
            player = new PlayerDoorChanging();
        return player;
    }
}
