package com.company.Snapshots;

import com.company.ProvinceConstruction.Province;

import java.util.ArrayList;

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
     * Given a MementoProvince sets an Object given a ProvinceAssembler Object.
     * @return new MementoProvince Object.
     */
    public ArrayList<Province> setMementoProvinces(ArrayList<MementoProvince> listOfctProvinces) {
        ArrayList<Province> newlst = new ArrayList<>();
        for (MementoProvince mp: listOfctProvinces){
            newlst.add(mp.getProvince());
        }
        return newlst;
    }

    public Province setprevMementoProvince(MementoProvince singleMp){
        return p = singleMp.getProvince();
    }

    /**
     * Getters and Setters
     */
    public Province getProvince(){
        return this.p;
    }

    public void setProvince(Province p){
        this.p = p;
    }

}