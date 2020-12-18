import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapMakerTest {
    Main main;
    ArrayList<String> allWords;
    String rawData;
    HashMapMaker hashMapMaker;
    HashMap<String, HashMap<String, Integer>> allGroceries;
    HashMap<String, Integer> milk;
    HashMap<String, Integer> bread;
    HashMap<String, Integer> cookies;
    HashMap<String, Integer> apples;
    HashMap<String, Integer> familyMembers;
    HashMap<String, HashMap<String, Integer>> homeHash;
    Integer errorCounter;

    @Before
    public void setup(){
        main = new Main();
        allWords = main.getAllWords();
        rawData = main.getRawData();
        hashMapMaker = new HashMapMaker(allWords);
        allGroceries = hashMapMaker.getAllGroceries();
        errorCounter = hashMapMaker.getErrorCounter();
        milk = hashMapMaker.getMilk();
        bread = hashMapMaker.getBread();
        cookies = hashMapMaker.getCookies();
        apples = hashMapMaker.getApples();

        familyMembers = new HashMap<>();
        familyMembers.put("cat", 3);
        familyMembers.put("dog", 1);
        familyMembers.put("people", 2);
        homeHash = new HashMap<>();
        homeHash.put("My Home", familyMembers);
    }

    @Test
    public void testConstructor(){
        Assert.assertNotNull(hashMapMaker);
    }

    @Test
    public void getMilk(){
        HashMap<String, Integer> expected = milk;
        HashMap<String, Integer> actual = hashMapMaker.getMilk();
        Assert.assertEquals(expected, actual);
        Assert.assertNotNull(expected);
    }

    @Test
    public void getBread(){
        HashMap<String, Integer> expected = bread;
        HashMap<String, Integer> actual = hashMapMaker.getBread();
        Assert.assertEquals(expected, actual);
        Assert.assertNotNull(expected);
    }

    @Test
    public void getCookies(){
        HashMap<String, Integer> expected = cookies;
        HashMap<String, Integer> actual = hashMapMaker.getCookies();
        Assert.assertEquals(expected, actual);
        Assert.assertNotNull(expected);
    }

    @Test
    public void getApples(){
        HashMap<String, Integer> expected = apples;
        HashMap<String, Integer> actual = hashMapMaker.getApples();
        Assert.assertEquals(expected, actual);
        Assert.assertNotNull(expected);
    }

    @Test
    public void testGetAllGroceries(){
        HashMap<String, HashMap<String, Integer>> expected = allGroceries;
        HashMap<String, HashMap<String, Integer>> actual = hashMapMaker.getAllGroceries();
        Assert.assertEquals(expected, actual);
        Assert.assertNotNull(expected);
    }

    @Test
    public void testGetErrorCounter(){
        Integer expected = 4;
        Integer actual = errorCounter;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountErrors(){
        Integer expected = 4;
        Integer actual = hashMapMaker.countErrors();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateMapForSpecificFood(){
        HashMap<String, Integer> expected = hashMapMaker.getMilk();
        HashMap<String, Integer> actual = hashMapMaker.createMapForSpecificFood("Milk");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddAllGroceries(){
        HashMap<String, HashMap<String, Integer>> expected = allGroceries;
        HashMap<String, HashMap<String, Integer>> actual = hashMapMaker.addAllGroceries();
        Assert.assertEquals(expected, actual);
    }
}
