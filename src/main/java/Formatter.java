import java.util.HashMap;

public class Formatter {

    public Formatter() {}

    public String leftAlignString (int width, String s) { // left align format in 7 spaces
        return String.format("%-" + width + s);
    }

    public String rightAlignString (int width, String s) { // right align format in 8 spaces
        return String.format("%" + width + s);
    }

    public StringBuilder formatMe(HashMap<String, Integer> foodName){ // returns 1 inner hashmap fully formatted
        StringBuilder printSection = new StringBuilder();
        printSection.append("\n");
//        for (String k : allWordsMapped.keySet()){
//            String formatted = centerString(11, allWordsMapped.get(k));
//            printer.append("|" + formatted);
//            int lineLengthCounter = printer.length();
//            if (lineLengthCounter == 31){
//                printer.append("|\n");
//            }
//        }
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
