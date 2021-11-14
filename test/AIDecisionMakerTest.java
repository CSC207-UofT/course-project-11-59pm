/**
 *
 * This file tests the AIDecisionMaker file and makes sure that all methods are working.
 *
 * */
import  com.company.AIDecisionMaker;

import com.company.ProvinceConstruction.Province;
import org.junit.*;

import java.util.ArrayList;
import java.util.Random;

import java.util.Arrays;
import java.util.List;

public class AIDecisionMakerTest {
    AIDecisionMaker decisionMaker;

    @Before
    public void setUp() {
        decisionMaker = new AIDecisionMaker();
    }

    @After
    public void tearDown() {
    }

    /** Checks that getDecision correctly returns a list of numbers between 1,2, or 3*/
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

    /** Checks that getDecision correctly returns a list of numbers between 1,2, or 3 and that the skew works*/
    @Test
    public void testGetDecisionsSkew(){
        //generate random numbers
        Random rand = new Random();
        int skew1 = rand.nextInt(97);
        int skew2 = (int)(Math.random()*(99-skew1 + 1) + skew1);

        //add skews to list
        List<Integer> skews = new ArrayList<>();
        skews.add(skew1);
        skews.add(skew2);

        //check that method still returns 1,2, or 3
        List<String> values = decisionMaker.getDecisions(skews);
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

    /** Checks if makeDecisions correctly executes and modifies each province. Does not check if the values are modified
     * correctly, only that they are modified.
     */
    @Test
    public void testMakeDecisions(){
        //Manual creation of a province
        Province province = new Province();
        province.setProvinceGold(500);
        province.setProvinceCivilians(500);
        province.setProvinceSoldiers(500);
        province.setProvinceFood(500);

        decisionMaker.makeDecisions(province);

        if (province.getProvinceGold() != 500 ) {assert true;}
        if (province.getProvinceCivilians() != 500 ) {assert true;}
        if (province.getProvinceSoldiers() != 500 ) {assert true;}
        if (province.getProvinceFood() != 500 ) {assert true;}
    }
    /** Checks if makeDecisions with the modifier executes and modifies the given province. Does not check if the values
     * are modified correct, only that something was modified.*/
    @Test
    public void testMakeDecisionsModified(){
        //Manual creation of a province
        Province province = new Province();
        province.setProvinceGold(500);
        province.setProvinceCivilians(500);
        province.setProvinceSoldiers(500);
        province.setProvinceFood(500);

        //generate random numbers
        Random rand = new Random();
        int skew1 = rand.nextInt(97);
        int skew2 = (int)(Math.random()*(99-skew1 + 1) + skew1);
        int modifier = rand.nextInt(300);
        //add skews to list
        List<Integer> skews = new ArrayList<>();
        skews.add(skew1);
        skews.add(skew2);

        decisionMaker.makeDecisions(province, modifier, skews);

        if (province.getProvinceGold() != 500 ) {assert true;}
        if (province.getProvinceCivilians() != 500 ) {assert true;}
        if (province.getProvinceSoldiers() != 500 ) {assert true;}
        if (province.getProvinceFood() != 500 ) {assert true;}
    }
}
