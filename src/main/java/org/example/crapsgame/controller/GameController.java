package org.example.crapsgame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.example.crapsgame.model.Dice;
import org.example.crapsgame.model.Game;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;

public class GameController {

    private int win_counter = 0;
    private int lose_counter = 0;

    @FXML
    private Label pointLabel, shootLabel, winLabel, loseLabel;

    @FXML
    private ImageView dice1ImageView, dice2ImageView;

    Dice dice1, dice2;
    ArrayList<Game> games = new ArrayList<Game>();
    Game game1 = new Game();
    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public GameController() {
        this.dice1 = new Dice();
        this.dice2 = new Dice();

    }

    @FXML
    public void onHandleButtonRollTheDice(ActionEvent event) {
        this.games.add(game1);
        try {
            this.dice1.rollDice();
            this.dice2.rollDice();
            this.game1.rollDices(dice1, dice2);
            this.dice1ImageView.setImage(this.dice1.getDiceImage());
            this.dice2ImageView.setImage(this.dice2.getDiceImage());
            this.pointLabel.setText(String.valueOf(this.game1.getPoint()));
            this.shootLabel.setText(String.valueOf(this.game1.getShoot()));
            if (game1.isWin()) {
                win_counter++;
                this.game1.setPoint(0);
                this.game1.setShootCount(0);
            }
            if (game1.isLose()) {
                lose_counter++;
                this.game1.setPoint(0);
                this.game1.setShootCount(0);
            }
            this.winLabel.setText(String.valueOf(win_counter));
            this.loseLabel.setText(String.valueOf(lose_counter));
        }catch(Exception e) {
            showAlert("Error durante el juego: " + e.getMessage());
            //Se muestra una alerta si se genera el número 7 en los dados
        }
    }

    @FXML
    public void onHandleButtonShowInstructions(ActionEvent event) {

        Alert alert = new Alert(AlertType.INFORMATION);


        alert.setTitle("Instrucciones del Juego Craps");

        alert.setHeaderText("Reglas Del Juego Craps:");


        alert.setContentText(""
                + "1. Si sacas un 7 o 11 en el primer tiro, ganas automáticamente.\n"
                + "2. Si sacas un 2, 3 o 12, pierdes (Craps).\n"
                + "3. Si sacas otro número (4, 5, 6, 8, 9, 10), ese será el 'punto'.\n"
                + "4. Debes seguir tirando hasta sacar el mismo número del punto para ganar.\n"
                + "5. Si sacas un 7 antes de igualar el punto, pierdes.");


        alert.showAndWait();
    }

}