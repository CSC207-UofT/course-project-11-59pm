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
    public Province setMementoProvinces(MementoProvince mementoProvince) {
        p = mementoProvince.getProvince();
        return p;
    }

//    public Province setprevMementoProvince(MementoProvince singleMp){
//        return p = singleMp.getProvince();
//    }

    /**
     * Getters and Setters
     */
    public Province getProvince(){
        return p;
    }

    public void setProvince(Province p){
        this.p = p;
    }

    public static void main(String[] args) {
        OriginatorProvince o = new OriginatorProvince();
        CaretakerProvince c = new CaretakerProvince();

        Province p = new Province();
        p.setProvinceCivilians(100);
        p.setProvinceSoldiers(101);
        p.setProvinceGold(102);
        p.setUserProvinceName("BLah");
        System.out.println("Province: " + p);
        o.setProvince(p);
        MementoProvince mp = o.createMementoProvinces();
        c.getMementoProvinceList();
        System.out.println("The current elements of MementoProvince " + c.getMementoProvinceList().size());
        System.out.println("Adding the province into the list!");

        c.addMementoProvince(mp); // ADD

        System.out.println();
        System.out.println("The current elements of MementoProvince " + c.getMementoProvinceList().size());
        List<MementoProvince> lst = c.getMementoProvinceList();

        for (MementoProvince aaa: lst){
            System.out.println("Number of Soliders: " + aaa.getProvince().getProvinceSoldiers());
        }

        System.out.println("setting new values");
        p.setProvinceCivilians(200);
        p.setProvinceSoldiers(201);
        p.setProvinceGold(202);
        MementoProvince mp2 = o.createMementoProvinces();
        c.addMementoProvince(mp2); // ADD
        System.out.println("Province: " + p);


        // desired [p1, p2]
        System.out.println();
        System.out.println("The current elements of MementoProvince " + c.getMementoProvinceList().size());
        System.out.println("---------------------------");
        for (MementoProvince aaa: lst){
            System.out.println("Number of Soliders: " + aaa.getProvince().getProvinceSoldiers());
            System.out.println(c.getMementoProvince(0).getProvince().getProvinceSoldiers());
            System.out.println(c.getMementoProvince(1).getProvince().getProvinceSoldiers());
        }
        System.out.println(lst);
        System.out.println("1st valeu "+ lst.get(0).getProvince());
        System.out.println("2nd valeu "+ lst.get(1).getProvince());


    }
}
