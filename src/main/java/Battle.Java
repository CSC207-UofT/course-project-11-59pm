package main.java;

import java.util.*;

/**
 * This class represnts the battle that takes place
 * at the end of every round. It will keep track of
 * who is participating within the battle at the end
 * of the round and what the resutls of the battle
 * will be.
 */
class Battle{

    private final Map<Provinces, List<Object>> participant;

    /**
     * Construct a battle with the given participants
     * and which tactics they have used to win the battle
     * @param participnats given participants
     * participants will have the key as the the provice object that is participating
     *                     and the value as a ArrayList [<who they will attack>, <what form attack>]</what></who>
     */
    public Battle(Map participnats) {
        this.participant= participnats;
    }

    /**
     * Returns an ArrayList of the key set of this.participants to give a
     * faire chance for all participants of the battle
     */
    public List setUpBattle(){
        Set participant_set = this.participant.keySet();
        List<String> lst = new ArrayList<>();
        for(Object o: participant_set){
            lst.add((String) o);
        }
        Collections.shuffle(lst); //this is the line that randomizes the order of
        // the participants
        return lst;
    }

    /**
     * Prints the participants and their choice of attack and maginitude in the
     * order of the lis returned from setUpBattle
     */
    public void printBattle() {
       for(Provinces p: this.participant.keySet()){
           Provinces other_province = (Provinces) this.participant.get(p).get(0);
           System.out.println("Province " + p.getName() + " has entered into battle with " +
                   other_province.getName() + " province, and is using " + this.participant.get(p).get(1)
                   + " force capacity.");
       }
    }

    /**
     * Returns whether this province will surrender to the attacking participant
     */
    public boolean willSurrender(String province){
        return true;
    }
    /**
     * updates each provinces stats after each battle has taken place
     */
    public void updateStats(){
        for(Provinces p: this.participant.keySet()){
            Provinces province = (Provinces) this.participant.get(p).get(0);
            Integer attack = (Integer) this.participant.get(p).get(1);
            province.changeStats(attack);
        }
    }
}