package main.java;

public class Province4 extends Province {
     /*
     * Instances Variables
     */
    private int populationCount;

    private String rajan = "D";
    // TODO: CHANGE "ANSH" to a Predefined vs UserChoice

    // Constructors
    public Province4(int count, String kingName){
        this.populationCount = count;
        this.rajan = kingName;
    }

    @Override
    public int population() {return this.populationCount;}

    @Override
    public String getRaja() {return this.rajan;}
}
