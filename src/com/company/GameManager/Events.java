package com.company.GameManager;
import java.util.Random;
import java.util.*;

/**
 *  This file contains the implementation for the Events Class.
 *  Responsibility: This file generates Random Events based on
 *  the RNG, which then is obtained by the GameEngine.
 */

public class Events {
    // Instance Variable: a Map of a String and List of Integers
    private static final Map<String, List<Integer>> map = new HashMap<>();
    public Events(){
        map.put("Do you want to marry the neighbouring kingdoms daughter?", Arrays.asList(10, 80, -20, -20, 1, 1, 1, 1));
        map.put("Do you want to hold a party for the citizens?", Arrays.asList(-50, 100, 20, -40, 1, 1, 1, 1));
        map.put("Do you want to start a crusade?", Arrays.asList(-10, -50, 50, 0, 1, 1, 1, 1));
        map.put("Do you want to slay the fiery dragon?", Arrays.asList(60, -10, -40, 20, 1, 1, 1, 1));
        map.put("Do you want to kill your daughter", Arrays.asList(20, -100, -20, 1, 1, 1, 1, 1));

        /* The first value is the province followed by the event, and the second value in order is the change in
         * (Civilians, Gold, Soldiers, Food, subtract Gold, subtract civil, subtract soldiers, subtract food)
         * If you answer yes, they get added
         * If you answer no, they get subtracted
         * */
    }

    // TODO: Howard, Do we need this method? If so, implement within the GameEngine. Otherwise, remove
    public static String getEvent(int eventNumber){
        return (String) map.keySet().toArray()[eventNumber];
    }

    /**
     * Return a randomly generates a Key from the preset Map provided.
     */
    public static String getRandomEvent(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(map.size());
        return (String) map.keySet().toArray()[randomNumber];
    }
    /**
     * Returns the List of Integers.
     * Preconditions: the Key must be within the preset Map provided.
     * @param Key represents the key of the map of type String
     */
    public static List<Integer> getValues(String Key){
        return map.get(Key);
    }
}
