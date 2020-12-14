import java.util.ArrayList;
import java.util.HashMap;

public class HashMapMaker {
    ArrayList<String> wordList;
    Integer errorCounter; //considers only missing words as errors
    HashMap<String, Integer> milk;
    HashMap<String, Integer> bread;
    HashMap<String, Integer> cookies;
    HashMap<String, Integer> apples;
    HashMap<String, HashMap<String, Integer>> allGroceries;

    public HashMapMaker(ArrayList<String> allWords) {
        wordList = allWords;
        errorCounter = countErrors();
        milk = createMapForSpecificFood("Milk");
        bread = createMapForSpecificFood("Bread");;
        cookies = createMapForSpecificFood("Cookies");;
        apples = createMapForSpecificFood("Apples");;
        allGroceries = addAllGroceries();
    }

    public HashMap<String, Integer> getMilk() { return milk; }

    public HashMap<String, Integer> getBread() { return bread; }

    public HashMap<String, Integer> getCookies() { return cookies; }

    public HashMap<String, Integer> getApples() { return apples; }

    public HashMap<String, HashMap<String, Integer>> getAllGroceries() { return allGroceries; }

    public Integer getErrorCounter() { return errorCounter; }

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
                    Integer value = mapForFoodName.get(foodName);
                    mapForFoodName.replace(foodName, value+1); //if yes, value++;
                } else {
                    mapForFoodName.put(foodName, 1); //if no, put in hashmap
                }
                //add price
                if (!wordList.get(i+3).equalsIgnoreCase("Type")){
                    String price = wordList.get(i+3);
                    if (mapForFoodName.keySet().contains(price)){
                        Integer value = mapForFoodName.get(price);
                        mapForFoodName.replace(price, value+1); //if yes, value++;
                    } else {
                        mapForFoodName.put(price, 1); //if no, put in hashmap
                    }
                }
                //add date
                if (wordList.get(i+5).equalsIgnoreCase("Expiration")) {
                    String date = wordList.get(i+6);
                    if (mapForFoodName.keySet().contains(date)){
                        Integer value = mapForFoodName.get(date);
                        mapForFoodName.replace(date, value+1); //if yes, value++;
                    } else {
                        mapForFoodName.put(date, 1); //if no, put in hashmap
                    }
                }
                if (!wordList.get(i+5).equalsIgnoreCase("Expiration")){
                    String date = wordList.get(i+7);
                    if (mapForFoodName.keySet().contains(date)){
                        Integer value = mapForFoodName.get(date);
                        mapForFoodName.replace(date, value+1); //if yes, value++;
                    } else {
                        mapForFoodName.put(date, 1); //if no, put in hashmap
                    }
                }
            }
        }
        return mapForFoodName;
    }

    public HashMap<String, HashMap<String, Integer>> addAllGroceries(){
        HashMap<String, HashMap<String, Integer>> groceries = new HashMap<>();
        groceries.put("Milk", milk);
        groceries.put("Bread", bread);
        groceries.put("Cookies", cookies);
        groceries.put("Apples", apples);
        return groceries;
    }
}
