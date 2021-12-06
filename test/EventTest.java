import  com.company.GameManager.Events;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventTest {

    @Test
    public void testEvent() {
        String ev = Events.getRandomEvent();
        ArrayList<String> listOfEvents = new ArrayList<>();
        listOfEvents.add("Do you want to marry the neighbouring kingdoms daughter?");
        listOfEvents.add("Do you want to hold a party for the citizens?");
        listOfEvents.add("Do you want to start a crusade?");
        listOfEvents.add("Do you want to slay the fiery dragon?");
        listOfEvents.add("Do you want to kill your daughter");
        assert (listOfEvents.contains(ev));
    }

    @Test
    public void testEventGetValue() {
        String ev = Events.getRandomEvent();
        List<Integer> lst = Events.getValues(ev);
        assert (Objects.equals(lst.size(), 8));
    }
}
