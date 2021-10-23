/**
 * This file contains the implementation for the
 * Provinces Class.
 * Responsibility: The Province is responsible for representing a
 * Provinces Object that contains the attribute within a Province.
 *
 **/

package main.java;

public class Provinces {
    /**
     * Instances Variables:
     * money: represents the total money that the province has.
     * civilians: represents the total number of civilians in a province.
     * solider: represents the total number of soldiers in a province.
     * food: represents the total number of food in a province.
     */
    private int gold;
    //TODO: Preset only for now. Until the implementation is done and running
    private int civilians = 100;
    private int soldiers = 100;
    private int food = 200;
    private String raja;
    private String provinceName;
    private boolean IsPlayer = false;
    private boolean active = true;

    /**
    * Constructor
    */
    public Provinces(String raja, String provinceName, int money, int civilians, int soldier, int food){
        this.raja = raja;
        this.provinceName = provinceName;
        this.gold = money;
        this.civilians = civilians;
        this.soldiers = soldier;
        this.food = food;

    //TODO: Delete the duplicate methods from the UserPlayer class.

    }
    /**
    * Get the total number of people in a province. The total population is the sum
     * of the civilians and soldiers in a province.
    */
    public int getTotalPopulation(){
        return this.civilians + this.soldiers;
    }
    /**
    * Purchase food, where food is in a ratio of 2:1 with the gold for the population within the province.
    * @param desisredFoodUnits is the number of food that a province wants to purchase
    */
    public void buyFood(int desisredFoodUnits){
        boolean check = false;
        // check if the province has enough gold -- this.gold > 0.
        if (this.gold == 0) {
            // TODO: Need to find a way to print a Execption: NotEnoughMoney
        // check if the desiredFoodUnits are affordable with the current gold
        } else if (this.gold - (desisredFoodUnits / 2) < 0){
              // TODO: Need to find a way to print a Execption: NotEnoughMoney
        // Otherwise, update food and gold.
        } else {
            this.food += (desisredFoodUnits * 2);
            this.gold -= desisredFoodUnits / 2;
        }
    }

    /**
     * Adds the number of soldiers, where 1:5 with the gold in a province.
     * @param soldierCount is the number of food that a province wants to purchase
     */
    public void enlistSoldiers(int soldierCount){
        boolean check = false;

        // check if the province has enough money
        if (this.gold == 0) {
            // TODO: Need to find a way to print a Execption: NotEnoughMoney
        } else if (this.gold - soldierCount * 5 < 0){
            // TODO: Need to find a way to print a Execption: NotEnoughMoney
        } else {
            this.soldiers += soldierCount;
            this.gold -= soldierCount * 5;
        }
    }

    /**
     * Trains the number of civilians to soldiers.
     * @param desiredSoldiers is the number of food that a province wants to purchase
     */
    public void trainCivilains(int desiredSoldiers){
        boolean check = false;

        if (this.civilians == 0){
            // TODO: Need to find a way to print a Execption: NotEnoughMoney
        } else {
            this.soldiers += desiredSoldiers;
            this.civilians -= desiredSoldiers;
        }
    }

    /**
     * Collects the tax from the population of the given province as revenue at the end of each round,
     * where teh tax is the number of golds.
     */
    public void collectTax() {
        this.gold += ((this.soldiers + this.civilians) * 0.2);
    }
    /**
     * TODO: WRITE THE DOCUMENTATION!
     */
    public void changeStats(int death){
        this.soldiers -= death;
    }
    /**
     *  Getters and Setters for the Instance Variables
     */
    public int getCivilians() {
        return civilians;
    }

    public void setCivilians(int civilians) {
        this.civilians = civilians;
    }

    public int getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(int soldiers) {
        this.soldiers = soldiers;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
//    private boolean active = true;
//    private int populationCount;
//    private int money;// TODO: For now keeping it only to money
//    private String raja;
//    private String provinceName;
//    private boolean IsPlayer = false;
//
//    /**
//     * A new LoginController for the use case defined by the LoginInputBoundary
//     */
//    public Provinces(int populationCount, String raja,
//                     String provinceName, int money){
//        this.populationCount = populationCount;
//        this.raja = raja;
//        this.provinceName = provinceName;
//        this.money = money;
//        this.active = true;
//        this.IsPlayer = false;
//    }
//
//    /** Getter for the populationCount */
//    public int getPopulationCount() {
//        return populationCount;
//    }
//    /** Getter for the populationCount */
//    public boolean getAliveStatus(){
//        return active;
//    }
//
//    /** Getter for the getProvinceName=*/
//    public String getName(){ return this.provinceName; }
//
//    /**
//     * Changes the stats for the given province by decreasing
//     * the population within the province
//     * @param death represents the number of people that died during a Battle
//     * */
//    public void changeStats(int death){
//        this.populationCount -= death;
//    }
//
//}
