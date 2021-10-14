package main.java.provinces;

public class Province3 extends Province {
     /*
     * Instances Variables
     */
    private int populationCount;

    private String rajan = "C";
    // TODO: CHANGE "ANSH" to a Predefined vs UserChoice

    // Constructors
    public Province3(int count, String kingName){
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
