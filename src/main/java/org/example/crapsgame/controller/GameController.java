package org.example.crapsgame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.example.crapsgame.model.Dice;
import org.example.crapsgame.model.Game;

import java.util.ArrayList;

public class GameController {

    @FXML
    private Label pointLabel, shootLabel, winLabel, loseLabel;

    @FXML
    private ImageView dice1ImageView, dice2ImageView;

    Dice dice1, dice2;
    ArrayList<Game> games = new ArrayList<Game>();
    Game game1 = new Game();

    public GameController() {
        this.dice1 = new Dice();
        this.dice2 = new Dice();

    }

    @FXML
    public void onHandleButtonRollTheDice(ActionEvent event) {
        this.games.add(game1);
        this.dice1.rollDice();
        this.dice2.rollDice();
        this.game1.rollDices(dice1, dice2);
        this.dice1ImageView.setImage(this.dice1.getDiceImage());
        this.dice2ImageView.setImage(this.dice2.getDiceImage());
        this.pointLabel.setText(String.valueOf(this.game1.getPoint()));
        this.shootLabel.setText(String.valueOf(this.game1.getShoot()));
        this.winLabel.setText(String.valueOf(this.game1.isWin()));
        this.loseLabel.setText(String.valueOf(this.game1.isLose()));

    }

}
