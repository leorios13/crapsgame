package org.example.crapsgame.model;

import javafx.scene.image.Image;

public class Dice {
    private static final String PATH = "/org/example/crapsgame/images/dices/";
    private Image diceImage;
    private int value;

    public Dice (){
        this.value = 0;
    }

    public Image getDiceImage() {
        return diceImage;
    }

    public int getValue() {
        return this.value;
    }

    public void rollDice() {
        this.value = (int)(Math.random() * 7) + 1; //Se incluyó el número 7 para mostrar la excepción
        this.diceImage = new Image(
                getClass().getResourceAsStream(PATH + "dice" + this.value + ".png")
        );
    }
}
