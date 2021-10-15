package runFiles;

import main.java.Player;

import main.java.Provinces;

import org.junit.*;

import static org.junit.Assert.*;

import java.io.*;

public class mainTest {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    /*This function will test the Player class and make sure that the object is created properly
    * The test assigns values to the object and makes sure that the correct value is returned*/
    @Test
    public void testPlayer(){
        Player person = new Player("bruh", false, 200);
        assertEquals(false, person.getStatus());
        assertEquals(200, person.getMoney());

    }
    /*This function will test the Province class and make sure that the object is created properly
     * The test assigns values to the object and makes sure that the correct value is returned
     * In addition, this test also sees if changeStats() will actually alter the populationCount
     * */
    @Test
    public void testProvinces(){
        Provinces province = new Provinces(30000, "allah", "Krukutee", 2000);
        assertEquals(30000, province.getPopulationCount());
        assertEquals("Krukutee", province.getName());
        assertEquals(true, province.getAliveStatus());
        province.changeStats(10000);
        assertEquals(20000, province.getPopulationCount());

    }

}
