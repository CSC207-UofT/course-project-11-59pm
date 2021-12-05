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
        map.put("A neighboring king is fielding suitors for his daughter, who is particularly taken with your second " +
                "son; will you make the match?", Arrays.asList(10, 80, 30, -40, 1, 1, 1, 1));

        map.put("Morale is running low in the province. A party would reinvigorate the civilians, and potentially " +
                "attract more people to your cause. Will you do it?", Arrays.asList(20, -40, 30, -30, 1, 1, 1, 1));

        map.put("Your clergymen are looking for more financial support in exchange for some valuable military " +
                "endorsement. Will you accept their deal?", Arrays.asList(-15, -20, 60, -20, 1, 1, 1, 1));

        map.put("Motivated by attacks on the province, your military commander proposes a training program to " +
                "prepare your civilians for future conflicts. Will you approve the program?",
                Arrays.asList(20, -30, 60, -30, 1, 1, 1, 1));

        map.put("A fiery dragon has made its home in your mountains, and is setting crops and livestock ablaze. " +
                "Will you slay the dragon?", Arrays.asList(20, 40, -100, 40, 1, 1, 1, 1));

        map.put("Your first-born son, ambitious and jealous after a lifetime living in your shadow, is revealed " +
                "to be spying on you for your enemies. The punishment for his treachery is death. Will you carry " +
                "it out?", Arrays.asList(-20, 40, -20, 50, 1, 1, 1, 1));

        /* The first value is the province followed by the event, and the second value in order is the change in
         * (Civilians, Gold, Soldiers, Food, subtract Gold, subtract civil, subtract soldiers, subtract food)
         * If you answer yes, they get added
         * If you answer no, they get subtracted
         * */
    }

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
