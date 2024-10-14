package org.example.crapsgame.model;

public class Game {
    private int shootCount;
    private int shoot;
    private int point;
    private boolean win;
    private boolean lose;
    Dice dice1, dice2;

    public Game() {
        this.shootCount = 0;
        this.shoot = 0;
        this.point = 0;
    }

    public int getShoot() {
        return this.shoot;
    }

    public int getShootCount() {
        return this.shootCount;
    }

    public int getPoint() {
        return this.point;
    }

    public boolean isWin() {
        this.win = (shootCount == 1 && (shoot == 7 || shoot == 11)) || (shootCount > 1 && shoot == point);
        return this.win;
    }

    public boolean isLose() {
        this.lose = (shootCount == 1 && (shoot == 2 || shoot == 3 || shoot == 12)) || (shootCount > 1 && shoot == 7);
        return this.lose;
    }

    public int rollDices(Dice dice1, Dice dice2) {
        this.dice1 = dice1;
        this.dice2 = dice2;

        int shootDice1 = this.dice1.getValue();
        int shootDice2 = this.dice2.getValue();

        this.shoot = shootDice1 + shootDice2;
        this.shootCount += 1;

        if(shootCount == 1 && (shoot == 4 || shoot == 5 || shoot == 6 || shoot == 8 || shoot == 9 || shoot == 10)){
            this.point = shoot;
        }

        return this.shoot;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setShootCount(int shootCount){
        this.shootCount = shootCount;
    }

}
