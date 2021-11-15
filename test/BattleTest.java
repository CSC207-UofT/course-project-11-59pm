/**
 *
 * This file tests the Battle file and makes sure that all methods are working.
 *
 * */
import  com.company.Battle;

import com.company.ProvinceConstruction.ProvinceAssembler;
import com.company.ProvinceConstruction.Province;
import com.company.ProvinceConstruction.ProvinceBuilder;
import org.junit.*;

import java.util.*;

public class BattleTest {
    private Battle battle;
    private ProvinceAssembler pa;

    @Before
    public void setUp() {
        pa = new ProvinceAssembler();
        battle = new Battle(pa);
    }

    @After
    public void tearDown() {
    }

    /** Checks that startsBattle correctly returns the name of the winning province*/
    @Test
    public void testStartsBattle(){
        ProvinceBuilder p1 = new ProvinceBuilder();
        ProvinceAssembler p = new ProvinceAssembler(p1);

        p.makeUserProvince("Ontario");
        Province ontario = p.getUserProvince();
        Province enemy = battle.optForBattle();

        String result = battle.startsBattle(ontario, enemy);

        assert (Objects.equals(result, ontario.getUserProvinceName()) | Objects.equals(result, enemy.getAiProvinceName()));
    }
}
