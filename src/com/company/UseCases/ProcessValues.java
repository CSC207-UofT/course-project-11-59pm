package com.company.UseCases;

import com.company.ProvinceConstruction.Province;

import java.util.List;

/**
 *  This file contains the implementation for the ProcessValues Class.
 *  Responsibility: This file is updates all the values for BOTH
 *  the User and AI provinces, where the values are updated depending
 *  on the choice the user's make and AI's provinces make.
 */

public class ProcessValues {

    /** The updating of attributes for provinces given a string that represents the choice the user wanted to make
     *
     * @param userDecision the string number that the user wants to update. Corresponds with given choices.
     *                     1 corresponds to boosting food for gold,
     *                     2 corresponds to boosting soldiers for civilians,
     *                     3 corresponds to boosting gold for civilians
     * @param province the province that will be modified. Can be a user province or an AI province
     * @param value the amount that the user wants to change their attributes by. Each attribute is changed by a
     *              different modifier.*/
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

    /** Acts similarly to getUserDecision, but rather than modifying by a value given by the player, this modifies
     * multiple values that are preset in the event. When called this passes a list that represents the values to be
     * modified in order of gold, civ, soldiers, food
     *
     * @param userDecision in Y,N which represents if the user wanted to act on this decision
     * @param province the province that  will be affected
     * @param value a list of values that corrosponds with the mutiple values that will be affected. This means that
     *              a list passed as [10,20,30,40] will modify gold by 10, civilians by 20, soldiers by 30, and food by
     *              40. Added or subtraced is dependant on the value of userDecision. */
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
            province.setProvinceGold(currentValue1 + value.get(4));
            province.setProvinceCivilians(currentValue2 + value.get(5));
            province.setProvinceSoldiers(currentValue3 + value.get(6));
            province.setProvinceFood(currentValue4 + value.get(7));
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
