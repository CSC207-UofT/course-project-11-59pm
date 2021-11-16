/**
 *
 * This file tests the Battle file and makes sure that all methods are working.
 *
 * */
import com.company.UseCases.Battle;

import com.company.ProvinceConstruction.ProvinceAssembler;
import com.company.ProvinceConstruction.Province;
import com.company.ProvinceConstruction.ProvinceBuilder;
import org.junit.*;

import java.util.*;

public class BattleTest {
    private Battle b1;
    private ProvinceAssembler p;

    @Before
    public void setUp() {
        b1 = new Battle();
        ProvinceBuilder p1 = new ProvinceBuilder();
        p = new ProvinceAssembler(p1);
    }

    @After
    public void tearDown() {
    }

    /** Checks that startsBattle correctly returns the name of the winning province*/
    @Test
    public void testStartsBattle(){
        Province opp = p.create().get(0);
        p.makeUserProvince("Ontario");
        Province user = p.getUserProvince();
        String result = b1.startsBattle(user, opp);


        assert (Objects.equals(result, user.getUserProvinceName()) | Objects.equals(result, opp.getAiProvinceName()));
    }
}
