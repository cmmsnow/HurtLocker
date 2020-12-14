import java.util.ArrayList;
import java.util.HashMap;

public class Formatter {

    public Formatter() {}

    public String rightAlignString (String string) { // right align format in 8 spaces
        return String.format("%8s", string);
    }

    public String formatMe(HashMap<String, Integer> foodName){ // returns 1 inner hashmap fully formatted
        ArrayList<String> keysFoodName = new ArrayList<>();
        StringBuilder printSection = new StringBuilder();
        for (String k : foodName.keySet()) { keysFoodName.add(k); }
        for (int i=0; i< keysFoodName.size(); i++){
            if (keysFoodName.get(i).matches("([a-zA-Z]+)")){
                printSection.append("Name:  " + rightAlignString(keysFoodName.get(i)) + " \t \t " + "seen:   " + foodName.get(keysFoodName.get(i)) + " times\n");
            }
        }
        printSection.append("--------------- \t \t ---------------\n");
        for (int i=0; i< keysFoodName.size(); i++){
            if (keysFoodName.get(i).matches("(\\d[.]\\d{2})")){
                printSection.append("Price:     " + (keysFoodName.get(i)) + " \t \t " + "seen:   " + foodName.get(keysFoodName.get(i)) + " times\n");
            }
        }
        for (int i=0; i< keysFoodName.size(); i++){
            if (keysFoodName.get(i).matches("(\\d[/]\\d{2}[/](\\d{4}))")){
                printSection.append("Date: " + keysFoodName.get(i) + " \t \t " + "seen:   " + foodName.get(keysFoodName.get(i)) + " times\n");
            }
        }
        printSection.append("=============== \t \t ===============\n");
        return printSection.toString();
    }

    public void finalPrint(HashMap<String, HashMap<String, Integer>> allGroceries, Integer errorCount){
        for (String k : allGroceries.keySet()){
            HashMap<String, Integer> foodItem = allGroceries.get(k);
            System.out.println(formatMe(foodItem));
        }
        System.out.println("Errors           \t \t seen:   " + errorCount + " times\n");
    }

}
