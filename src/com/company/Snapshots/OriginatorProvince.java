package com.company.Snapshots;

import com.company.ProvinceConstruction.Province;

import java.util.ArrayList;
import java.util.List;

public class OriginatorProvince {
    private Province p;


    /**
     * Creates MementoProvince Object given a ProvinceAssembler Object
     * @return new Memento Province Object
     */
    public MementoProvince createMementoProvinces(){
        return new MementoProvince(p);
    }

    /**
     * Given a MementoProvince sets an Object given a Province Object.
     * @return new MementoProvince Object.
     */

    public List<Province> setListOfMementoProvinces(List<MementoProvince> mementoProvinceList) {
        List<Province> ListOfP = new ArrayList<>();
        for (MementoProvince mp: mementoProvinceList){
            p = mp.getProvince();
            ListOfP.add(p);
        }
        return ListOfP;
    }

    /**
     * Getters and Setters
     */
    public Province getProvince(){
        return p;
    }

    public void setProvince(Province p){
        this.p = p;
    }
}
