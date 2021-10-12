/**
 * This class represnts the battle that takes place
 * at the end of every round. It will keep track of
 * who is participating within the battle at the end
 * of the round and what the resutls of the battle
 * will be.
 */
class Battle{

    /**
     * Construct a battle with the given participants
     * and which tactics they have used to win the battle
     * @param participnats given participants
     * participants will have the key as the the provice object that is participating
     *                     and the value as a ArrayList [<who they will attack>, <what form attack>]</what></who>
     */
    public Battle(Map participnats) {
        this.participant= participnats
    }

    /**
     * Returns an ArrayList of the key set of this.participants to give a
     * faire chance for all participants of the battle
     */
    public ArrayList setUpBattle(){
        Set participant_set = this.participants;
        List<String> lst = new ArrayList<String>();
        for(String o: participant_set){
            lst.add(o.getName())
        }
        Collections.shuffle(lst); //this is the line that randomizes the order of
        // the participants
        return lst
    }

    /**
     * Prints the participants and their choice of attack and maginitude in the
     * order of the lis returned from setUpBattle
     */
    public String printBattle(ArrayList lst){
        for(String p: lst){
            System.out.println("Battle participant "+ p + " has chosen to attack" + self.participnats.get(p)[0] +
                    " With battle attack " + self.participnats.get(p)[1]+ ".")
        }
    }

    /**
     * Returns whether this province will surrender to the attacking participant
     */

    /**
     * updates each provinces stats after each battle has taken place
     */
}