import java.util.ArrayList;
import java.util.HashMap;

public class HashMapMaker {
    ArrayList<String> wordList;
    HashMap<String, Integer> milk;
    HashMap<String, Integer> bread;
    HashMap<String, Integer> cookies;
    HashMap<String, Integer> apples;
    HashMap<String, HashMap<String, Integer>> allGroceries;
    Integer errorCounter = 0;

    public HashMapMaker(ArrayList<String> allWords) {
        wordList = allWords;
        milk = createMapForSpecificFood("Milk");
        bread = createMapForSpecificFood("Bread");;
        cookies = createMapForSpecificFood("Cookies");;
        apples = createMapForSpecificFood("Apples");;
        allGroceries = addAllGroceries();
    }

    public HashMap<String, Integer> getMilk() {
        return milk;
    }

    public HashMap<String, Integer> getBread() {
        return bread;
    }

    public HashMap<String, Integer> getCookies() {
        return cookies;
    }

    public HashMap<String, Integer> getApples() {
        return apples;
    }

    public HashMap<String, HashMap<String, Integer>> getAllGroceries() {
        return allGroceries;
    }

    public Integer getErrorCounter() {
        return errorCounter;
    }

    public HashMap<String, Integer> createMapForSpecificFood(String foodName){
        HashMap<String, Integer> mapForFoodName = new HashMap<>();
        //loop through wordList, checking for foodName
        //if found, add each present value behind it to hashmap as key with value of 1
        //if value not present, increment error counter
        //if key already in hashmap, increment value
        return mapForFoodName;
    }

    public HashMap<String, HashMap<String, Integer>> addAllGroceries(){
        HashMap<String, HashMap<String, Integer>> groceries = new HashMap<>();
        //add all foodnames as keys and hashmaps as values
        return groceries;
    }

//    public Integer getOccurencesOfWordInList(ArrayList<String> inputList, String inputWord){
//        Integer counter = 0;
//        for (String w : inputList){
//            if (w.equalsIgnoreCase(inputWord)){
//                counter++;
//            }
//        }
//        return counter;
//    }
}
