import com.company.Battle;
import com.company.ProvinceConstruction.Province;
import com.company.ProvinceConstruction.ProvinceAssembler;
import com.company.ProvinceConstruction.ProvinceBuilder;

import com.company.Snapshots.OriginatorProvince;
import com.company.Snapshots.CaretakerProvince;
import com.company.Snapshots.MementoProvince;
import org.junit.*;

import java.util.ArrayList;

/**
 *
 * This file tests the ProvinceConstruction package and makes sure that all methods are working.
 *
 * */

public class MementoTest {
    private ProvinceAssembler provinceUserAssembler;
    private ProvinceBuilder provinceBuilder;
    private Province playerProvince;
    private OriginatorProvince origProvince;
    private CaretakerProvince ctProvince;
    private ProvinceAssembler pa;
    /**
     * Added a tester to see if the memento design pattern holds the previous state
     * of the province properly
     */
    @Test
    public void testCreation(){
        // send the province state to the Originator
        String name = "Ontario";
        provinceBuilder = new ProvinceBuilder();
        provinceUserAssembler = new ProvinceAssembler(provinceBuilder);
        provinceUserAssembler.makeUserProvince(name);
        playerProvince = provinceUserAssembler.getUserProvince();
        origProvince = new OriginatorProvince();
        ctProvince = new CaretakerProvince();
        origProvince.setProvince(playerProvince);

        // Create a mememto Object from the given state.
        MementoProvince mp = origProvince.createMementoProvinces();

        // send to the CareTackerProvince
        ctProvince.addMementoProvince(mp);

        // return the prev state Province Object
        //return origProvince.setprevMementoProvince(ctProvince.getPrevMementoProvince());
        }
}

