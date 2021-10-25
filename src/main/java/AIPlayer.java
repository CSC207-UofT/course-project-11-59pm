/* This Would Represent the AI-Players that are in charge of their respective AI Province*/

package main.java;

import java.util.Random;

public class AIPlayer implements Player {
    @Override
    public void buyFood(int desirableFoodUnits, Provinces p) {}
    //TODO: Need to Finish This

    @Override
    public void enlistSoldiers(int soldierCount, Provinces p) {}
    //TODO: Need to Finish This

    @Override
    public void trainCivilians(int trainCount, Provinces p) {}
    //TODO: Need to Finish This

    @Override
    public void collectTax(Provinces p) {}
    //TODO: Need to Finish This

    @Override
    public boolean getBattleDecision() {
        //Rng system here!
        Random rand = new Random();
        int upperbound = 25;
        int intRandom = rand.nextInt(upperbound);
        return intRandom > 15;
    }
}
