public class Formatter {

    public Formatter() {}

    public String leftAlignString (int width, String s) { //left align format in 7 spaces
        return String.format("%-" + width + s);
    }

    public String rightAlignString (int width, String s) { //right align format in 6 spaces
        return String.format("%" + width + s);
    }

    public String formatMe(){ //formats words into grouped strings so they can be put into hashmap
        StringBuilder printSection = new StringBuilder();

        printSection.append("");
//        for (String k : allWordsMapped.keySet()){
//            String formatted = centerString(11, allWordsMapped.get(k));
//            printer.append("|" + formatted);
//            int lineLengthCounter = printer.length();
//            if (lineLengthCounter == 31){
//                printer.append("|\n");
//            }
//        }
        printSection.append("============= \t \t =============\n");
        return printSection.toString();
    }

    public String finalPrint(){
        StringBuilder groceryList = new StringBuilder();
        //append everything
        //groceryList.append("Errors         \t \t seen: " + getNumOfMissingWords() + " times\n");
        return groceryList.toString();
    }

}
