package com.company.Snapshots;

import java.util.ArrayList;
import java.util.List;

public class CaretakerProvince {
    /**
     * Instance Variables:
     * listOfMementoProvinces: An ArrayList of to store the MementoProvinces Objects
     */
    private List<MementoProvince> listOfMementoProvinces = new ArrayList<>();

    /**
     * Adds the given MementoProvince Object to the ArrayList.
     * @param mp represents a given MementoProvince Object
     */
    public void addMementoProvince(MementoProvince mp){this.listOfMementoProvinces.add(mp);
    }

    /**
     * Getters
     */
    public MementoProvince getMementoProvince(int index){
        return listOfMementoProvinces.get(index);
    }

    public List<MementoProvince> getMementoProvinceList(){
        return this.listOfMementoProvinces;
    }

}
