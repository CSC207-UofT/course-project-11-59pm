package main.java.provinces;

public class PlayersProvince extends Province {
     /*
     * Instances Variables
     */
    private int populationCount;

    private String rajan = "B";
    // TODO: CHANGE "ANSH" to a Predefined vs UserChoice

    public PlayersProvince(int count, String kingName){
        this.populationCount = count;
        this.rajan = kingName;
    }

    /* Getter Methods */

    public int getPopulationCount() {
        return populationCount;
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

