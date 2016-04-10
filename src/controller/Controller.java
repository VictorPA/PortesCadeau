package controller;

import doors.Game;
import guitest.MyJFrame;

/**
 * Created by Victor on 10/04/2016.
 */
public class Controller {

    Game game;
    MyJFrame view;
    int result;

    public Controller(Game game){
        this.game = game;
    }

    public void send(int gamesInput, int doorsInput, int playerInput) {
        game.send(gamesInput,doorsInput,playerInput);
        this.view.receive(game.getResult(),game.getDoorsNumber());

    }

    public void setView(MyJFrame view){
        this.view = view;
    }



}
