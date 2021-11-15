package com.company;

import com.company.ProvinceConstruction.Province;

import java.util.List;

public class ProcessValues {

    public ProcessValues() {

    }

    public void getUserDecision(String userDecision, Province province, int value){
        if (userDecision.equals("1")){
            int currentValue = province.getProvinceCivilians();
            int currentValue2 = province.getProvinceGold();
            province.setProvinceCivilians(currentValue + value/2);
            province.setProvinceGold(currentValue2 - value);
        }
        else if (userDecision.equals("2")){
            int currentValue = province.getProvinceSoldiers();
            int currentValue2 = province.getProvinceCivilians();
            province.setProvinceSoldiers(currentValue + value);
            province.setProvinceCivilians(currentValue2 - value);
        }
        else if (userDecision.equals("3")){
            int currentValue = province.getProvinceGold();
            int currentValue2 = province.getProvinceCivilians();
            province.setProvinceGold(currentValue + value * 2);
            province.setProvinceCivilians(currentValue2 - value);

        }
    }

    public void getUserEventDecision(String userDecision, Province province, List<Integer> value){
        if (userDecision.equals("Y")){
            int currentValue1 = province.getProvinceGold();
            int currentValue2 = province.getProvinceCivilians();
            int currentValue3 = province.getProvinceSoldiers();
            int currentValue4 = province.getProvinceFood();
            province.setProvinceGold(currentValue1 + value.get(0));
            province.setProvinceCivilians(currentValue2 + value.get(1));
            province.setProvinceSoldiers(currentValue3 + value.get(2));
            province.setProvinceFood(currentValue4 + value.get(3));

        }
//        else if (userDecision.equals("N")){
//            int currentValue1 = province.getProvinceGold();
//            int currentValue2 = province.getProvinceCivilians();
//            int currentValue3 = province.getProvinceSoldiers();
//            int currentValue4 = province.getProvinceFood();
//            province.setProvinceGold(currentValue1 - value.get(4));
//            province.setProvinceCivilians(currentValue2 - value.get(5));
//            province.setProvinceSoldiers(currentValue3 - value.get(6));
//            province.setProvinceFood(currentValue4 - value.get(7));
//        }
    }
}
