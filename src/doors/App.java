package doors;

import Factories.PlayerFactory;
import controller.Controller;
import guitest.MyJFrame;

import java.awt.*;
import java.util.Scanner;
import java.io.*;

/**
 * Created by Victor on 08/04/2016.
 *
 * @author Brandon Barajas
 */

public class App {
    public static void main(String[] args) throws IOException {

        /**TODO
         * a good programm;
         */


        Game game = new Game(new PlayerFactory());
        Controller controller = new Controller(game);
        MyJFrame view = new MyJFrame(controller);
        view.setVisible(true);
        controller.setView(view);


    }
}
