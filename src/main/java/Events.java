package main.java;
import java.util.Random;
import java.util.*;

class Events {
    /*This class is called on my gameManager to present random events to players.
     * It alters province resources and player entities
     * It will take input from the controller
     * */
//    ArrayList ma = new ArrayList();
    private static Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public Events(){
        map.put("Do you want to marry the neighbouring kingdoms daughter?", Arrays.asList(10, 80, -20, -20));
        map.put("Do you want to hold a party for the citizens?", Arrays.asList(-50, 100, 20, -40));
        map.put("Do you want to start a crusade?", Arrays.asList(-10, -50, 50, 0));
        map.put("Do you want to slay the fiery dragon?", Arrays.asList(60, -10, -40, 20));
        map.put("Do you want to kill your daughter", Arrays.asList(20, -100, -20, 1));
        /* The first value is the province followed by the event, and the second value in order is the change in
         * (Gold, Civilians, Soldiers , Food)
         * If you answer yes, they get added
         * If you answer no, they get subtracted
         * */
    }
    public static String getEvent(int eventNumber){
        return (String) map.keySet().toArray()[eventNumber];
    }
    public static String getRandomEvent(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(map.size());
        return (String) map.keySet().toArray()[randomNumber];
    }

    public static List returnValues(String Key){
        return map.get(Key);
    }
}
