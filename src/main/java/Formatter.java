import java.util.ArrayList;
import java.util.HashMap;

public class Formatter {

    public Formatter() {}

    public String rightAlignString (int width, String s) { // right align format in 8 spaces
        return String.format("%" + width + s);
    }

    public StringBuilder formatMe(HashMap<String, Integer> foodName){ // returns 1 inner hashmap fully formatted
        ArrayList<String> keysFoodName = new ArrayList<>();
        StringBuilder printSection = new StringBuilder();
        for (String k : foodName.keySet()) { keysFoodName.add(k); }
        for (int i=0; i< keysFoodName.size(); i++){
            if (keysFoodName.get(i).matches("([a-zA-Z]+)")){
                printSection.append("Name:  " + rightAlignString(8, keysFoodName.get(i)) + " \t \t " + "seen:   " + foodName.get(keysFoodName.get(i)) + " times\n");
            }
        }
        printSection.append("--------------- \t \t ---------------\n");
        for (int i=0; i< keysFoodName.size(); i++){
            if (keysFoodName.get(i).matches("(\\d[.]\\d{2})")){
                printSection.append("Price: " + rightAlignString(8, keysFoodName.get(i)) + " \t \t " + "seen:   " + foodName.get(keysFoodName.get(i)) + " times\n");
            }
        }
        for (int i=0; i< keysFoodName.size(); i++){
            if (keysFoodName.get(i).matches("(\\d[/]\\d{2}[/](\\d{4})))")){
                printSection.append("Date: " + keysFoodName.get(i) + " \t \t " + "seen:   " + foodName.get(keysFoodName.get(i)) + " times\n");
            }
        }
        printSection.append("=============== \t \t ===============\n");
        return printSection;
    }

    public String finalPrint(HashMap<String, HashMap<String, Integer>> allGroceries, Integer errorCount){
        StringBuilder groceryList = new StringBuilder(); // append everything, hashmap by hashmap
        for (String k : allGroceries.keySet()){
            HashMap<String, Integer> foodItem = allGroceries.get(k);
            groceryList.append(formatMe(foodItem));
        }
        groceryList.append("Errors           \t \t seen:   " + errorCount + " times\n");
        return groceryList.toString();
    }

}
