package com.company.Snapshots;

import com.company.ProvinceConstruction.ProvinceAssembler;

public class OriginatorProvince {
    private ProvinceAssembler pA;

    /**
     * Creates MomentoProvince Object given a ProvinceAssembler Object
     * @return new Momento Province Object
     */
    public MomentoProvince createMomentoProvinces(){
        return new MomentoProvince(pA);
    }

    /**
     * Given a MomentoProvince sets an Object given a ProvinceAssembler Object
     * @return new MomentoProvince Object
     */

    public void setMomentoProvinces(MomentoProvince mp){
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
