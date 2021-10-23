/*Player Interface which manages both the AI-pLayers and the user player. */

package main.java;

public interface Player {
    //TODO: Document.

    /* Trade for food units in exchange for gold */
    public void buyFood(int desirableFoodUnits, Provinces p);

    /* Trade for additional soldiers in exchange for gold*/
    public void enlistSoldiers(int soldierCount, Provinces p);

    /* Trains the civilians of the province into soldiers */
    public void trainCivilians(int trainCount, Provinces p);

    /*Collects gold from the population of the given province at the end of each round */
    public void collectTax(Provinces p);
}
