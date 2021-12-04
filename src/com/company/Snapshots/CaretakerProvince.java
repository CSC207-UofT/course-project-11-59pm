package com.company.Snapshots;

import java.util.ArrayList;
import java.util.List;

/**
 *  This file contains the implementation for the CaretakerProvince Class.
 *  Responsibility: This file stores all the Memento Provinces Object
 *  which are saved and restored by the given index.
 */

public class CaretakerProvince {
    /**
     * Instance Variables:
     * listOfMementoProvinces: An ArrayList of to store the MementoProvinces Objects.
     */
    private final List<MementoProvince> listOfMementoProvinces = new ArrayList<>();

    /**
     * Adds the given MementoProvince Object to the ArrayList.
     * @param mp represents a given MementoProvince Object
     */
    public void addMementoProvince(MementoProvince mp){this.listOfMementoProvinces.add(mp);
    }

   /**
    * Returns a MementoProvince Object by the given index.
    * Preconditions: index must be within the size of the List<MementoProvince>,
    *      in other words, 0  <= index <= |List<MementoProvince>|
    * @param index represents the index at of the MementoProvince Object
    */
    public MementoProvince getMementoProvince(int index){
        return listOfMementoProvinces.get(index);
    }

    /**
     * Getter
     */
    public List<MementoProvince> getMementoProvinceList(){
        return this.listOfMementoProvinces;
    }

}
