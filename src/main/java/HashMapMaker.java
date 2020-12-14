import java.util.ArrayList;
import java.util.HashMap;

public class HashMapMaker {
    ArrayList<String> wordList;
    HashMap<String, Integer> milk;
    HashMap<String, Integer> bread;
    HashMap<String, Integer> cookies;
    HashMap<String, Integer> apples;
    HashMap<String, HashMap<String, Integer>> allGroceries;
    Integer errorCounter;

    public HashMapMaker(ArrayList<String> allWords) {
        wordList = allWords;
        errorCounter = countErrors();
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

    public Integer countErrors(){
        Integer errors = 0;
        for (int i=0; i<wordList.size(); i++){
            if (wordList.get(i)=="Name" && wordList.get(i+1)=="Price") errors++;
            if (wordList.get(i)=="Price" && wordList.get(i+1)=="Type") errors++;
            if (wordList.get(i)=="Type" && wordList.get(i+1)=="Expiration") errors++;
            if (wordList.get(i)=="Expiration" && wordList.get(i+1)=="Name") errors++;
        }
        return errors;
    }

    public HashMap<String, Integer> createMapForSpecificFood(String foodName){
        HashMap<String, Integer> mapForFoodName = new HashMap<>();
        for (int i=0; i<wordList.size(); i++){
            if (wordList.get(i).equalsIgnoreCase("Name") && wordList.get(i+1).equalsIgnoreCase(foodName)){
                //add foodName
                if ((mapForFoodName.keySet() != null) && (mapForFoodName.keySet().contains(foodName))){
                    //if yes, value++;
                } else {
                    //if no, put in hashmap
                }
                //add price
                //add expirationDate
            }
        }
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
