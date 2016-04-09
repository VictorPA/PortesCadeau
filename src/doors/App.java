package doors;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.awt.GraphicsEnvironment;
import java.net.URISyntaxException;

/**
 * Created by Victor on 08/04/2016.
 * @author Brandon Barajas
 */

public class App {
    public static void main(String[] args) throws IOException {

        /**TODO
         * a good programm;
         */

        new Game();
        Scanner scanner = new Scanner(System.in);
        int rejouer;
        while (true) {
            try {
                System.out.println("Relancer une simulation?");
                System.out.println("Chiffre: Oui");
                System.out.println("Autre: Terminer");
                rejouer = Integer.parseInt(scanner.nextLine());
                new Game();

            } catch (NumberFormatException e) {
                System.out.println("Fin de la simulation");
                break;
            }

        }


    }
}
