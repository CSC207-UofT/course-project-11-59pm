package com.company;
import com.company.Provinces;
public class battle {
    
    public void provincesBattle(Provinces player1, Provinces player2) {
        int player1_army = player1.getSoldiers();
        int player2_army = player2.getSoldiers();
        int updated_player1_army = player1_army;
        int updated_player2_army = player2_army;

        while (player1_army *0.30 < updated_player1_army || player1_army *0.30 < updated_player1_army ) {
            float ratio1 = updated_player1_army / updated_player2_army;
            float ratio2 = updated_player2_army / updated_player1_army;

            float player1Num = (float) (Math.random() * ratio1);
            float player2Num = (float) (Math.random() * ratio2);

            if (player1Num > player2Num) {
                updated_player2_army = updated_player2_army - (int) (updated_player2_army * (ratio1*2));
            } else {
                updated_player1_army = updated_player1_army - (int) (updated_player1_army * (ratio2*2));
            }
        }
        // TODO: update the name of the provinces
        // implement the battle logic so that it is fair
        if(player1_army *0.30 < updated_player1_army){
            player1.setSoldiers(updated_player1_army);
            player2.setSoldiers(updated_player2_army);
            System.out.println("provinceName 1 wins");
        }
        else{
            player1.setSoldiers(updated_player1_army);
            player2.setSoldiers(updated_player2_army);
            System.out.println("provinceName 2 wins");
        }

    }
}
