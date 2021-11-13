package com.company.momento;

import com.company.builder.ProvinceAssembler;

public class MomentoProvince {
    private ProvinceAssembler pA;

    /**
     * Constructor that sets the ProvinceAssembler.
     * @param pA represents a ProvinceAssembler Object
     */
    public MomentoProvince(ProvinceAssembler pA) {
        super();
        this.pA = pA;
    }

    /**
     * Getters and Setters
     */
    public ProvinceAssembler getProvince() {
        return this.pA;
    }

    public void setProvince(ProvinceAssembler p) {
        this.pA = p;
    }

}
