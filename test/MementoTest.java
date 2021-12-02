//import com.company.ProvinceConstruction.Province;
//import com.company.ProvinceConstruction.ProvinceAssembler;
//import com.company.ProvinceConstruction.ProvinceBuilder;
//
//import com.company.Snapshots.OriginatorProvince;
//import com.company.Snapshots.CaretakerProvince;
//import com.company.Snapshots.MementoProvince;
//import org.junit.*;
//
//import java.util.Objects;
//
///**
// *
// * This file tests the ProvinceConstruction package and makes sure that all methods are working.
// *
// * */
//
//public class MementoTest {
//
//
//    /**
//     * Added a tester to see if the memento design pattern holds the previous state
//     * of the province properly
//     */
//    @Test
//    public void testCreation(){
//        // send the province state to the Originator
//        String name = "Ontario";
//        ProvinceBuilder pb = new ProvinceBuilder();
//        ProvinceAssembler pA = new ProvinceAssembler(pb);
//        pA.makeUserProvince(name);
//        Province playerProvince = pA.getUserProvince();
//        OriginatorProvince origProvince = new OriginatorProvince();
//        CaretakerProvince ctProvince = new CaretakerProvince();
//        origProvince.setProvince(playerProvince);
//
//        // Create a mememto Object from the given state.
//        MementoProvince mp = origProvince.createMementoProvinces();
//
//        // send to the CareTackerProvince
//        ctProvince.addMementoProvince(mp);
//        Province restoredProvince = origProvince.setprevMementoProvince(ctProvince.getPrevMementoProvince());
//
//        assert (Objects.equals(playerProvince, restoredProvince));
//        assert (playerProvince.getUserProvinceName().equals(restoredProvince.getUserProvinceName()));
//        assert (playerProvince.getProvinceSoldiers() == restoredProvince.getProvinceSoldiers());
//        assert (playerProvince.getProvinceCivilians() == restoredProvince.getProvinceCivilians());
//        assert (playerProvince.getProvinceFood() == restoredProvince.getProvinceFood());
//
//}
//}
//
