package doors;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Victor on 08/04/2016.
 */
public class Game {
    public Game(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrer le nombre de parties");
        int gamesInput;
        while(true){
            try {
                gamesInput = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erreur");
                System.out.println("Entrer le nombre de parties");
            }
        }

        System.out.println("Entrer le nombre de portes");
        int doorsInput;
        while(true){
            try {
                doorsInput = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erreur");
                System.out.println("Entrer le nombre de portes");
            }
        }

        System.out.println("Entrer le type de joueur.");
        System.out.println("1: Garder la même porte");
        System.out.println("2: Toujours changer");
        Player player = null;
        int playerInput = 0;

        while (true) {
            try {
                playerInput = Integer.parseInt(scanner.nextLine());
                if(playerInput != 1 && playerInput != 2)
                    continue;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erreur");
                System.out.println("Entrer le type de joueur.");
                System.out.println("1: Garder la même porte");
                System.out.println("2: Toujours changer");
            }

        }
        if(playerInput == 1)
            player = new PlayerKeepingDoor();
        if(playerInput == 2)
            player = new PlayerDoorChanging();

        Room game = new Room(doorsInput);
        ArrayList<Door> doors = game.getDoors();
        int doorNumbers = doors.size();

        int n;


        for (n = 0; n < gamesInput; ++n) {
            game.resetRoom();
            Random rand = new Random();
            int randomNum = rand.nextInt(doorNumbers);

            //Door picking
            doors.get(randomNum).choose();

            //
            int x =-1;

            for (int i = 0; i < doors.size(); ++i) {
                if (doors.get(i).isChosen() && doors.get(i).isGifted()) {
                    x = i;
                    continue;
                } else if (doors.get(i).isChosen() || doors.get(i).isGifted()) {
                    continue;
                }
                doors.get(i).open();

            }
            if(x != -1){
                if (x == 0)
                    doors.get(1).close();
                else if (x == doors.size() - 1)
                    doors.get(doors.size() - 2).close();
                else
                    doors.get(x - 1).close();
            }



            player.end(doors);


        }
        System.out.println("Nombre de portes : "+doorNumbers);
        System.out.println("Le joueur a gagné " + player.score + " fois sur " + n+".");
    }
}
