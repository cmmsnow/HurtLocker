import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    String rawData;
    ArrayList<String> allWords;
    HashMap<String, String> allWordsMapped;

    public Main() {
        rawData = loadFile();
        allWords = getWords();
        allWordsMapped = createMap();
    }

    public String getRawData() {
        return rawData;
    }

    public ArrayList<String> getAllWords() {
        return allWords;
    }

    public HashMap<String, String> getAllWordsMapped() {
        return allWordsMapped;
    }

    private String loadFile(){ //gets raw data
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("RawData.txt").getFile());
        StringBuilder result = new StringBuilder("");
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public ArrayList<String> getWords(){
        ArrayList<String> allWords = new ArrayList<>();
        String wordsPattern = "(([a-zA-Z]+)|(\\d[.]\\d\\d)|(\\d[/]\\d\\d[/](\\d{4})))";
        Pattern pat = Pattern.compile(wordsPattern);
        Matcher matcher = pat.matcher(rawData);
        while (matcher.find()) {
            allWords.add(matcher.group());
        }
        return allWords;
    }

    //should this be "getOccurencesOfWordIn-MAP" ?
    public Integer getOccurencesOfWordInList(ArrayList<String> inputList, String inputWord){
        Integer counter = 0;
        for (String w : inputList){
            if (w.equalsIgnoreCase(inputWord)){
                counter++;
            }
        }
        return counter;
    }

    public HashMap<String, String> createMap(){
        HashMap<String, String> fullMap = new HashMap<>();
        //for loop: go through list + confirm pair exists, then place in map in ALLCAPS.
        //if value does not exist for key, place value in map as "".
        return fullMap;
    }

//    public String centerString (int width, String s) { //example of center format
//        return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
//    }

    //need method to left align text with colon in 6 spaces

    //need method to right align text in 6 spaces

    public String formatMe(){
        StringBuilder printer = new StringBuilder();
//        for (String k : allWordsMapped.keySet()){
//            String formatted = centerString(11, allWordsMapped.get(k));
//            printer.append("|" + formatted);
//            int lineLengthCounter = printer.length();
//            if (lineLengthCounter == 31){
//                printer.append("|\n");
//            }
//        }
        return printer.toString();
    }

    public static void main(String[] args){
        Main main = new Main();
        ArrayList<String> allWords = main.getAllWords();
        System.out.println(allWords);
        HashMap<String, String> groceryList = main.getAllWordsMapped();
        System.out.println(main.formatMe());
    }
}
