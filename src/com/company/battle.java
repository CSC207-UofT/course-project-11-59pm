package com.company;
import com.company.Provinces;

import java.util.HashMap;
import java.util.Set;

/**
 * This is a class representation of a Battle. This class will deal with all the details of how provinces are
 * updated and merged during the battle.
 */

public class Battle {
    /**
     * This function take a hashmap of all the provinces and the province that they choose to go into battle with
     * and it will perform all the needed changes to it.
     * If the first provinces that go to battle are taken over, then the later provinces will no be able to go into
     * battle with the province that has been taken over (active).
     * @param battlemap
     */
    // TODO: extend this method to print out the inactive provinces and to see whether provinces want to attack others
    public void allProvinceBattle(HashMap<Provinces, Provinces> battlemap){
        // Loop through the key set of the battle hashmap and make each of the two provinces go into battle
        // the key province is the one that has decided to go into battle with the value province
        Integer i = 1;
        Set<Provinces> battlekey = battlemap.keySet();
        for(Provinces k: battlekey){
            System.out.println("~~~Battle " + i + " has begun~~~");
            i += 1;
            if (k.getStatus() && battlemap.get(k).getStatus()){
                // this line checks whether any of the two provinces are inactive before go into province
                System.out.println("Province " + k.getProvinceName() + " is attacking Province " +
                        battlemap.get(k).getProvinceName());
                this.provincesBattle(k, battlemap.get(k));
            }
            else{
                System.out.println("This province is no longer active, Battle cannot begin.");
            }
        }
        System.out.println("The battle round is finished.");
    }

    /**
     * This function takes in two players and makes them go to battle. The two provinces continue to be in battle
     * unless on of the provinces surrenders when their army count falls below 30% of its original value
     * @param player1
     * @param player2
     */
    public void provincesBattle(Provinces player1, Provinces player2) {
        //original values of the army of both provinces
        int player1_army = player1.getSoldiers();
        int player2_army = player2.getSoldiers();
        // values of the army that get modified over the course of the battle
        int updated_player1_army = player1_army;
        int updated_player2_army = player2_army;

        float ratio1 = (float) updated_player1_army / updated_player2_army;
        float ratio2 = (float) updated_player2_army / updated_player1_army;
        // if either province have less than 30% of their army left, they will surrender
        while (updated_player2_army > 0.3*player2_army && updated_player1_army > 0.30*player1_army) {
            // adding a bit of luck
            float player1Num = (float) (Math.random() * ratio1);
            float player2Num = (float) (Math.random() * ratio2);
            if (player1Num > player2Num) {
                updated_player2_army = updated_player2_army - (int) (updated_player2_army * (player1Num));
                if( updated_player2_army < 0){
                    updated_player2_army = 0;
                }
                System.out.println("Province " + player2.getProvinceName() + " has " + updated_player2_army + " army count.");
            } else {
                updated_player1_army = updated_player1_army - (int) (updated_player1_army * (player2Num));
                if(updated_player1_army < 0){
                    updated_player1_army = 0;
                }
                System.out.println("Province " + player1.getProvinceName() + " has " + updated_player1_army + " army count.");

            }
        }
        battleResult(player1, player2, player1_army, player2_army, updated_player1_army, updated_player2_army);

    }

    /**
     * This function takes in the two provinces that went to battle and their original army count and their post-battle
     * army count and will update the winning provinces army count by adding the losing provinces army and setting
     * the name of the losing province to "Conquered by <winning province name>".
     * @param player1
     * @param player2
     * @param player1_army
     * @param player2_army
     * @param updated_player1_army
     * @param updated_player2_army
     */
    private void battleResult(Provinces player1, Provinces player2, int player1_army, int player2_army,
                              int updated_player1_army, int updated_player2_army) {
        // TODO: Ask how to update the name of the province
        // TODO: Change other resources for the winning province
        // implement the battle logic so that it is fair
        if(updated_player1_army < 0.30*player1_army){
            player2.setSoldiers(updated_player1_army + updated_player2_army);
            player1.setSoldiers(0);
            player1.setStatus();
            System.out.println("Province "+ player1.getProvinceName() + " surrenders, Province " +
                    player2.getProvinceName() + " wins!");
            player1.setProvinceName("Province conquered by " + player2.getProvinceName() );

        }
        if(updated_player2_army < 0.3*player2_army){
            player1.setSoldiers(updated_player1_army + updated_player2_army);
            player2.setSoldiers(0);
            player2.setStatus();
            System.out.println("Province " +player2.getProvinceName() + " surrenders, Province " +
                    player1.getProvinceName() + " wins!");
            player2.setProvinceName("Province conquered by " + player1.getProvinceName() );
        }
    }
}