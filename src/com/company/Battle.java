/**
 * The Battle Class is responsible for the battles between 2 provinces
 */
package com.company;

/** This class represents the battle that takes place at the end of every round.
* It will keep track of who is participating within the battle at the end of the round
* and what the results of the battle will be.
*/ // TODO: Need to check the responsibilities
class Battle {

    private Provinces province1;
    private Provinces province2;

    public Battle(Provinces p1, Provinces p2) {
        province1 = p1;
        province2 = p2;

    }

    /**
     * Initiates a battle between two provinces object and then starts the battle
     * between the two provinces through ratios and returns the winner of the battle.
     * @param p1 represents the Object for the Province.
     * @param p2 represents the second Object for the Province.
     */
    public Provinces startsBattle(Provinces p1, Provinces p2) {
        // Get the number of soldier present for both the Provinces
        int player1_SoldierCount = p1.getSoldiers();
        int player2_SoldierCount = p2.getSoldiers();

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
                p1.setSoldiers(player1_SoldierCount);
                p2.setSoldiers(player1_SoldierCount);

            } else if (player1_Ratio > player2_Ratio) {
                float deaths = (float) Math.random() * player2_Ratio;
                player2_SoldierCount -= deaths;
                p1.setSoldiers(player1_SoldierCount);
                p2.setSoldiers(player2_SoldierCount);
            } else {
                float deaths = (float) Math.random() * player1_Ratio;
                player2_SoldierCount -= deaths;
            }
            battleRounds -= 1;

        }
        return getWinner(player1_SoldierCount, player2_SoldierCount);
    }

    private Provinces getWinner(int player1_AliveSoldier, int player2_AliveSoldier) {
        if (player1_AliveSoldier > player2_AliveSoldier) {
            return province1;
        }
        return province2;
    }
}

