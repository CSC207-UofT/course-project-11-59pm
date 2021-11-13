package com.company.momento;

import java.util.ArrayList;

public class CaretakerProvince {
    /**
     * Instance Variables:
     * listOfMomentoProvinces: An ArrayList of to store the MomentoProvinces Objects
     */
    private ArrayList<MomentoProvince> listOfMomentoProvinces = new ArrayList<>();

    /**
     * Adds the given MomentoProvince Object to the ArrayList.
     * @param mp represents a given MomentoProvince Object
     */
    public void addMomentoProvince(MomentoProvince mp){
        listOfMomentoProvinces.add(mp);
    }

    /**
     *
     * @param lowerBound represents the minimum bound on the MomentoProvince elements required.
     * @param upperBound represents the maximum bound on the Momento Objects elements required.
     */
    public ArrayList<MomentoProvince> getMomentoProvince(int lowerBound, int upperBound){
        int sizeOf = listOfMomentoProvinces.size();
        ArrayList<MomentoProvince> newListOfMomentoProvinces = new ArrayList<MomentoProvince>();
        if (lowerBound < sizeOf){
            while (lowerBound != upperBound){
                MomentoProvince target = this.listOfMomentoProvinces.get(lowerBound);
                newListOfMomentoProvinces.add(target);
                lowerBound += 1;
            }
        return newListOfMomentoProvinces;
        } else {
            return null;} //TODO: Need to add an exception
        }
}
