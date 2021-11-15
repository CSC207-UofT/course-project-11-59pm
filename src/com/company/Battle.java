package com.company;

import com.company.ProvinceConstruction.Province;
import com.company.ProvinceConstruction.ProvinceAssembler;
import com.company.ProvinceConstruction.ProvinceBuilder;

import java.util.*;

public class Battle {
    private ProvinceAssembler provinceAssembler;
    private ProvinceBuilder provinceBuilder;

    public Battle(ProvinceAssembler provinceAssembler) {
        this.provinceAssembler = provinceAssembler;
    }

    /**
     * Initiates a battle between two provinces object and then starts the battle
     * between the two provinces through ratios and returns the winner of the battle.
     * @param userProvince represents the Object for the Province.
     * @param aiProvince represents the second Object for the Province.
     */
    public String startsBattle(Province userProvince, Province aiProvince) {
        // Get the number of soldier present for both the Provinces
        int player1_SoldierCount = userProvince.getProvinceSoldiers();
        int player2_SoldierCount = aiProvince.getProvinceSoldiers();

        int battleRounds = 10;

        while (battleRounds >= 0) {
            // 1. Get the ratios for both the provinces
            float player1_Ratio = (float) player1_SoldierCount / player2_SoldierCount; // 100 / 80 = 8.0
            float player2_Ratio = (float) player2_SoldierCount / player1_SoldierCount; // 80 / 100 = 0.8

            // 2. Compare the ratios in each case: the higher ratios wins that round,
            // and causes the other province to lose number of soldiers.

            // 3. Update each soldier counts
            if (player1_Ratio == player2_Ratio) {
                float deaths = (float) Math.random() * (player2_Ratio + player1_Ratio);
                player1_SoldierCount -= deaths;
                player2_SoldierCount -= deaths;
                // Update the provinces stats: TODO: Not sure if I am allowed to update here
                // TODO: IF I am not alllowed to update this: Can I create Process Values for battle only?
                userProvince.setProvinceSoldiers(player1_SoldierCount);
                aiProvince.setProvinceSoldiers(player1_SoldierCount);

            } else if (player1_Ratio > player2_Ratio) {
                float deaths = (float) Math.random() * player2_Ratio;
                player2_SoldierCount -= deaths;
                userProvince.setProvinceSoldiers(player1_SoldierCount);
                aiProvince.setProvinceSoldiers(player2_SoldierCount);
            } else {
                float deaths = (float) Math.random() * player1_Ratio;
                player2_SoldierCount -= deaths;
            }
            battleRounds -= 1;

        }
        if (player1_SoldierCount > player2_SoldierCount){
            return userProvince.getUserProvinceName();
        }
        return aiProvince.getAiProvinceName();
    }

    private ArrayList<Province> getProvinces(){
        return provinceAssembler.create();
    }

    /**
     * This function will return either null or one province that is willing to go into battle with the UserProvince
     * @return
     */
    public Province optForBattle(){
        ArrayList<Province> provinceArrayList = getProvinces();
        ArrayList<Integer> intBattle = new ArrayList<>();
        ArrayList<Province> readyForBattle = new ArrayList<>();

        addBattleStatus(intBattle);

        for(int i = 0; i <=3; i++){
            if(intBattle.get(i) == 1){
                readyForBattle.add(provinceArrayList.get(i));
            }
        }
        if (readyForBattle.size() == 0){
            return null;
            //TODO: Need to print that none of the provinces wanna battle
        }
        Collections.shuffle(readyForBattle);
        return readyForBattle.get(0);

    }

    private void addBattleStatus(ArrayList<Integer> intBattle) {
        Random rand = new Random();
        for (int i = 0; i<=3; i++){
            intBattle.add(rand.nextInt(2));
        }
    }

    public static void main(String[] args) {
        ProvinceBuilder p1 = new ProvinceBuilder();
        ProvinceAssembler p = new ProvinceAssembler(p1);

        p.makeUserProvince("Teri Ma");
        Province q = p.getUserProvince();

                Battle b = new Battle(p);
        Province t = b.optForBattle();

        System.out.println(        b.startsBattle(q,t));

    }

}

