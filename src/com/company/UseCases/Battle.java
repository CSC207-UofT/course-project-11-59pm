package com.company.UseCases;

import com.company.UseCases.ProcessValues;
import com.company.ProvinceConstruction.Province;

public class Battle {
    ProcessValues processValues;

    public Battle() {
        ProcessValues processValues = new ProcessValues();
        this.processValues = processValues;
    }

    /**
     * Initiates a battle between two provinces object and then begins the battle
     * between the two provinces through ratios and returns the winner of the battle.
     * @param userProvince represents the Object for the Province.
     * @param aiProvince represents the second Object for the Province.
     */
    public String startsBattle(Province userProvince, Province aiProvince) {
        // Get the number of soldier present for both the Provinces
        int player1_SoldierCount = processValues.getBattleSoldiers(userProvince);
        int player2_SoldierCount = processValues.getBattleSoldiers(aiProvince);

        int battleRounds = 2;

        while (battleRounds >= 0) {
            // 1. Get the ratios for both the provinces
            float player1_Ratio = 5 * (float) player1_SoldierCount / player2_SoldierCount; // 100 / 80 = 8.0
            float player2_Ratio = 5 * (float) player2_SoldierCount / player1_SoldierCount; // 80 / 100 = 0.8

            // 2. Compare the ratios in each case: the higher ratios wins that round,
            // and causes the other province to lose number of soldiers.

            // 3. Update each soldier counts
            if (player1_Ratio == player2_Ratio) {
                int deaths = (int) Math.round(Math.random() * (player2_Ratio + player1_Ratio));

                player1_SoldierCount -= deaths;
                player2_SoldierCount -= deaths;

                processValues.battleRoundProcess(userProvince, player1_SoldierCount);
                processValues.battleRoundProcess(aiProvince, player2_SoldierCount);

            } else if (player1_Ratio > player2_Ratio) {
                float deaths = (float) Math.random() * player2_Ratio;
                player2_SoldierCount -= deaths;
                processValues.battleRoundProcess(userProvince, player1_SoldierCount);
                processValues.battleRoundProcess(aiProvince, player2_SoldierCount);
            } else {
                float deaths = (float) Math.random() * player1_Ratio;
                player1_SoldierCount -= deaths;
                processValues.battleRoundProcess(userProvince, player1_SoldierCount);
                processValues.battleRoundProcess(aiProvince, player2_SoldierCount);
            }
            battleRounds -= 1;

        }
        if (player1_SoldierCount > player2_SoldierCount){
            return processValues.battleWinner(userProvince);
        }
        return processValues.battleWinner(aiProvince);
    }
}

