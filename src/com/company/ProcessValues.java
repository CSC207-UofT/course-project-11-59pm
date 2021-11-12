package com.company;

import java.util.ArrayList;
import java.util.List;

public class ProcessValues {

    public ProcessValues() {

    }

    public void getUserDecision(String userDecision, Provinces province, int value){
        if (userDecision.equals("1")){
            int currentValue = province.getCivilians();
            int currentValue2 = province.getGold();
            System.out.println(currentValue);
            System.out.println("asldfkjsdf");
            province.setCivilians(currentValue + value/2);
            province.setGold(currentValue2 - value);
            System.out.println(currentValue);
        }
        else if (userDecision.equals("2")){
            int currentValue = province.getSoldiers();
            int currentValue2 = province.getCivilians();
            province.setSoldiers(currentValue + value);
            province.setCivilians(currentValue2 - value);
        }
        else if (userDecision.equals("3")){
            int currentValue = province.getGold();
            int currentValue2 = province.getCivilians();
            province.setGold(currentValue + value);
            province.setCivilians(currentValue2 - value);

        }
        else {
            System.out.println("sdf");
        }
    }

    public void getUserEventDecision(String userDecision, Provinces province, List<Integer> value){
        if (userDecision.equals("1")){
            int currentValue1 = province.getGold();
            int currentValue2 = province.getCivilians();
            int currentValue3 = province.getSoldiers();
            int currentValue4 = province.getFood();
            province.setGold(currentValue1 + value.get(0));
            province.setCivilians(currentValue2 + value.get(1));
            province.setSoldiers(currentValue3 + value.get(2));
            province.setFood(currentValue4 + value.get(3));

        }
        else if (userDecision.equals("2")){
            int currentValue1 = province.getGold();
            int currentValue2 = province.getCivilians();
            int currentValue3 = province.getSoldiers();
            int currentValue4 = province.getFood();
            province.setGold(currentValue1 - value.get(4));
            province.setCivilians(currentValue2 - value.get(5));
            province.setSoldiers(currentValue3 - value.get(6));
            province.setFood(currentValue4 - value.get(7));
        }
    }
}
