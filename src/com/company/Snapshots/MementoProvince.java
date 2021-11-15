package com.company.Snapshots;

import com.company.ProvinceConstruction.Province;

public class MementoProvince {
    private Province pA;

    /**
     * Constructor that sets the ProvinceAssembler.
     * @param pA represents a ProvinceAssembler Object.
     */
    public MementoProvince(Province pA) {
        super();
        this.pA = pA;
    }

    /**
     * Getters and Setters
     *
     */
    public Province getProvince() {
        return this.pA;
    }

    public void setProvince(Province p) {
        this.pA = p;
    }

}