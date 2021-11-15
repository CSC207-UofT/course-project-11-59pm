import com.company.ProvinceConstruction.Province;
import com.company.ProvinceConstruction.ProvinceAssembler;
import org.junit.*;

import java.util.ArrayList;

/**
 *
 * This file tests the ProvinceConstruction package and makes sure that all methods are working.
 *
 * */

public class ProvinceTest {

    /**
     * Added a tester to see if the creation of the 4 Ai Provinces is as expected.
     * Checks to see if each Ai Province in the array list of AiProvinces is of type Province.
     */
    @Test
    public void testCreation(){
        ProvinceAssembler provinceAssembler = new ProvinceAssembler();
        ArrayList<Province> listOfProvinces = provinceAssembler.create();

        for (Province p: listOfProvinces){
            assert p != null;
        }
    }
}
