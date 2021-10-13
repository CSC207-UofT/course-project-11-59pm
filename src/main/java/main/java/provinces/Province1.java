/**
 * This file contains the implementation for the
 * Province Interface.
 **/

package main.java.provinces;

public class Province1 extends Province {
    /*
    * Instances Variables
    */
    private int populationCount;

    private String rajan = "A";
    // TODO: CHANGE "ANSH" to the User's Name from the UserInterface

    // Constructors
    public Province1(int count, String kingName){
        this.populationCount = count;
        this.rajan = kingName;
    }

    @Override
    public int population() {
        return this.populationCount;
    }

    @Override
    public String getRaja() {
        return this.rajan;
    }
}
