package com.company.UseCases;

import com.company.ProvinceConstruction.Province;

import java.util.List;

public class ProcessValues {

    public ProcessValues() {

    }

    public void getUserDecision(String userDecision, Province province, int value){
        switch (userDecision) {
            case "3": {
                // civilians for gold; 1 civ: 2 gold
                int currentValue = province.getProvinceCivilians();
                int currentValue2 = province.getProvinceGold();
                province.setProvinceCivilians(currentValue - value);
                province.setProvinceGold(currentValue2 + 2*value);
                break;
            }
            case "2": {
                // civilians for soldiers; 1 civ:1 soldier
                int currentValue = province.getProvinceSoldiers();
                int currentValue2 = province.getProvinceCivilians();
                province.setProvinceSoldiers(currentValue + value);
                province.setProvinceCivilians(currentValue2 - value);
                break;
            }
            case "1": {
                // gold for food; 1 gold: 2 food
                int currentValue = province.getProvinceFood();
                int currentValue2 = province.getProvinceGold();
                province.setProvinceFood(currentValue + 2*value);
                province.setProvinceGold(currentValue2 - value);

                break;
            }
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
        else if (userDecision.equals("N")){
            int currentValue1 = province.getProvinceGold();
            int currentValue2 = province.getProvinceCivilians();
            int currentValue3 = province.getProvinceSoldiers();
            int currentValue4 = province.getProvinceFood();
            province.setProvinceGold(currentValue1 - value.get(4));
            province.setProvinceCivilians(currentValue2 - value.get(5));
            province.setProvinceSoldiers(currentValue3 - value.get(6));
            province.setProvinceFood(currentValue4 - value.get(7));
        }
    }

    //battle mathods that need processing values
    public int getBattleSoldiers(Province province) {
        return province.getProvinceSoldiers();
    }
    public void battleRoundProcess(Province p, int count) {
        p.setProvinceSoldiers(count);
    }

    public String battleWinner(Province p) {
        if(p.getUserProvinceName() == null){
            return p.getAiProvinceName();}
        return p.getUserProvinceName();
    }
}
