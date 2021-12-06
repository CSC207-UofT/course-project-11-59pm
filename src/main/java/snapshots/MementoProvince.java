package main.java.snapshots;

import main.java.provinceconstruction.Province;

/**
 *  This file contains the implementation for the MementoProvince Class.
 *  Responsibility: This file converts a given Province Object to a
 *  MementoProvince Object.
 */
public class MementoProvince {
    private Province pA;

    /**
     * Constructor that sets the ProvinceAssembler.
     * @param pA represents a ProvinceAssembler Object.
     */
    public MementoProvince(Province pA) {
        this.pA = pA;
    }

    /**
     * Getters and Setters
     */
    public Province getProvince() {
        return this.pA;
    }

    public void setProvince(Province p) {
        this.pA = p;
    }

}