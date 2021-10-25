/*Represents the user and it's respective province*/
package main.java;

public class UserPlayer<Province> implements Player {
    private Province userProvince;
    private String userName;

    public UserPlayer(Province userProvince, String userName) {
        this.userProvince = userProvince;
        this.userName = userName;
    }

    /**
     * Purchase food, where food is in a ratio of 2:1 with the gold for the population within the province.
     * @param desirableFoodUnits is the number of food that a province wants to purchase
     * @param p , the province that the User is Controlling.
     */
    @Override
    public void buyFood(int desirableFoodUnits, Provinces p) {
        if (p.getGold() == 0) {
            // TODO: Need to find a way to print a Execption: NotEnoughMoney
            // check if the desiredFoodUnits are affordable with the current gold
        } else if (p.getGold() - (desirableFoodUnits / 2) < 0){
            // TODO: Need to find a way to print a Execption: NotEnoughMoney
            // Otherwise, update food and gold.
        } else {
            p.setFood(p.getFood() + desirableFoodUnits * 2);
            p.setGold(p.getGold() + desirableFoodUnits / 2);
        }
    }
    /**
     * Adds the number of soldiers, where 1:5 with the gold in a province.
     * @param soldierCount is the number of food that a province wants to purchase
     * @param p , the province that the User is Controlling.
     */
    @Override
    public void enlistSoldiers(int soldierCount, Provinces p) {
        if (p.getGold() == 0) {
            // TODO: Need to find a way to print a Execption: NotEnoughMoney
        } else if (p.getGold() - soldierCount * 5 < 0){
            // TODO: Need to find a way to print a Execption: NotEnoughMoney
        } else {
            p.setSoldiers(soldierCount);
            p.setGold(p.getGold() - soldierCount * 5);
        }
    }

    /**
     * Trains the number of civilians to soldiers.
     * @param trainCount is the number of food that a province wants to purchase
     * @param p , the province that the User is Controlling.
     */
    @Override
    public void trainCivilians(int trainCount, Provinces p) {
        if (p.getCivilians() == 0){
            // TODO: Need to find a way to print a Execption: NotEnoughMoney
        } else {
            p.setSoldiers(p.getSoldiers() + trainCount);
            p.setCivilians(p.getCivilians() - trainCount);
        }
    }

    /**
     * Collects the tax from the population of the given province as revenue at the end of each round,
     * where teh tax is the number of golds.
     */
    @Override
    public void collectTax(Provinces p) {
        p.setGold((int) ((p.getSoldiers() + p.getCivilians()) *0.2)) ;
    }

    @Override
    public boolean getBattleDecision() {
        //TODO: Need to get this decision made by the user, for now it's as true;
        return true;
    }
}
