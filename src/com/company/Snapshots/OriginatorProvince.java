package com.company.Snapshots;

import com.company.ProvinceConstruction.ProvinceAssembler;

public class OriginatorProvince {
    private ProvinceAssembler pA;

    /**
     * Creates MementoProvince Object given a ProvinceAssembler Object
     * @return new Memento Province Object
     */
    public MementoProvince createMementoProvinces(){
        return new MementoProvince(pA);
    }

    /**
     * Given a MementoProvince sets an Object given a ProvinceAssembler Object.
     * @return new MementoProvince Object.
     */

    public void setMementoProvinces(MementoProvince mp){
        pA = mp.getProvince();
    }

    /**
     * Getters and Setters
     */
    public ProvinceAssembler getProvince(){
        return this.pA;
    }

    public void setProvince(ProvinceAssembler p){
        this.pA = p;
    }

}