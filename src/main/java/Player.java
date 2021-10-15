package main.java;
/*
The class is responsible for the Player. This class
can be extended to the NobilityPlayer
 */

public class Player {
    private int money;
    private String name;
    private boolean isDead;

    public Player(String name, boolean isDead, int money) {
        this.name = name;
        this.isDead = isDead;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public boolean getStatus(){
        return isDead;
    }
}
