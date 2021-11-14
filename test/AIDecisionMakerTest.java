import  com.company.AIDecisionMaker;

import com.company.userInterface;
import org.junit.*;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AIDecisionMakerTest {
    AIDecisionMaker decisionMaker;

    @Before
    public void setUp() {
        decisionMaker = new AIDecisionMaker();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetDecisions(){
        List<String> values = decisionMaker.getDecisions();
        List<String> validChoices = Arrays.asList("1","2","3");
        boolean valid;

        for (String value: values){
            valid = validChoices.contains(value);

            if (!valid){
                assert (false);
            }
        }

        assert (true);
    }
}
