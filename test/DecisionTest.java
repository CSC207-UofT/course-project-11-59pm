import main.java.gamemanager.Decisions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;
public class DecisionTest {
    /**
     *
     * This file tests the Decisions Class and makes sure that all methods are working.
     *
     * */
    private Decisions decisions;
    @Before
    public void setUp(){
        decisions = new Decisions();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDecision() {
        ArrayList<String> lst = new ArrayList<>();
        lst.add("Do you want to boost your food for one round?");
        lst.add("Do you want to enlist more soldiers?");
        lst.add("Do you want to increase revenue?");
        ArrayList dec = decisions.getDecisionQuestions();
        assert (Objects.equals(lst.size(), 3));
        for(Object d : dec){
            assert lst.contains(d);
        }

    }


}
