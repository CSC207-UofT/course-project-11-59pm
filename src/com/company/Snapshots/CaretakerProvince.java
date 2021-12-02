package com.company.Snapshots;

import java.util.ArrayList;

public class CaretakerProvince {
    /**
     * Instance Variables:
     * listOfMementoProvinces: An ArrayList of to store the MementoProvinces Objects
     */
    private final ArrayList<MementoProvince> listOfMementoProvinces = new ArrayList<>();

    /**
     * Adds the given MementoProvince Object to the ArrayList.
     * @param mp represents a given MementoProvince Object
     */
    public void addMementoProvince(MementoProvince mp){ listOfMementoProvinces.add(mp);
    }

    /**
     * Returns the ArrayList of the MementoProvince Objects given the upper and the lower bound.
     * @param lowerBound represents the minimum bound of the MementoProvince elements required.
     * @param upperBound represents the maximum bound of the Memento Objects elements required.
     */
    public ArrayList<MementoProvince> getListMementoProvince(int lowerBound, int upperBound){
        int sizeOf = listOfMementoProvinces.size();
        ArrayList<MementoProvince> newListOfMementoProvinces = new ArrayList<>();
        if (lowerBound < sizeOf){
            while (lowerBound < upperBound){
                MementoProvince target = listOfMementoProvinces.get(lowerBound);
                newListOfMementoProvinces.add(target);
                lowerBound += 1;
            }
            return newListOfMementoProvinces;
        } else {
            return null;} //TODO: Need to add an exception
    }
    /**
     * Getters
     */
    public MementoProvince getPrevMementoProvince(){
        return listOfMementoProvinces.get(0);
    }


    public ArrayList<MementoProvince> getListOfMementoProvinces() {
        return listOfMementoProvinces;
    }
}
