///**
// *
// * This file tests the gameState package and makes sure that all methods are working.
// *
// * */
//import com.company.ProvinceConstruction.Province;
//import  com.company.gameState.saveLoad;
//import  com.company.gameState.gameState;
//
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.*;
//import org.junit.*;
//
//public class gameStateTest {
//    public String filePath;
//    @Before
//    public void setUp() {
//
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Added a tester to see if the creation of the 4 Ai Provinces is as expected
//     * Checks to see if each Ai Province in the array list of AiProvinces is of type Province.
//     */
//    @Test
//    public void testSaveLoad() throws IOException {
//
//
//
//
//        ArrayList<Object> list = new ArrayList<Object>();
//        list.add("test");
//        list.add("test2");
//        list.add("test3");
//
//        gameState gs = new gameState(list);
//
//
//        Path resourceDirectory = Paths.get("src");
//        String filePath = resourceDirectory.toFile().getAbsolutePath();
//
//        if (filePath.endsWith("/") || filePath.endsWith("\\") )
//        {
//            filePath = filePath + "test.ser";
//        }
//        else {
//            filePath = filePath + "/test.ser";
//        }
//
//        saveLoad.saveGame(filePath, gs);
//
//        gameState gs2 = saveLoad.loadGame(filePath);
//
//        ArrayList<Object> newList = gs2.getSaveState();
//
//        ArrayList<Object> newList2 = new ArrayList<>();
//        newList2.add("test");
//        newList2.add("test2");
//        newList2.add("test3");
//
//        assert Objects.equals(newList,newList2);
//
//    }
//
//    @Test
//    public void gameStateSizeTest() {
//
//        gameState gs = new gameState();
//        gs.addGameStateElement("First");
//        gs.addGameStateElement("Second");
//        gs.addGameStateElement("Third");
//
//        assert gs.getSize()  == 3;
//
//
//    }
//
//    @Test
//    public void gameStateSaveListTest() {
//
//        gameState gs = new gameState();
//        gs.addGameStateElement("First");
//        gs.addGameStateElement("Second");
//        gs.addGameStateElement("Third");
//
//        ArrayList<Object> list = new ArrayList<>();
//        list.add("First");
//        list.add("Second");
//        list.add("Third");
//        assert gs.getSaveState().equals(list);
//
//
//    }
//
//    @Test
//    public void gameStateIterator() {
//
//        gameState gs = new gameState();
//        gs.addGameStateElement("First");
//        gs.addGameStateElement("Second");
//        gs.addGameStateElement("Third");
//
//        for (Object x: gs){
//            assert x != null;
//        }
//
//    }
//}