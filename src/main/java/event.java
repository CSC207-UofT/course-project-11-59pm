import java.util.*;

class events {
    /*This class is called on my gameManager to present random events to players.
     * It alters province resources and player entities
     * It will take input from the controller
     * */
//    ArrayList ma = new ArrayList();
    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public void constructEvents(){
        map.put("province1MarryDaughter", Arrays.asList(80, 60, 70, 50, 20));
        map.put("province4holdParty", Arrays.asList(20, 80, 10, 40, 30));
        map.put("province2holdCrusade", Arrays.asList(20, 80, 10, 40, 30));
        /* The first value is the province followed by the event, and the second value in order the
         * (weight, affectOnParameter1, affectOnParameter2, affectOnParameter3 ,affectOnParameter4)
         * */
    }
}
