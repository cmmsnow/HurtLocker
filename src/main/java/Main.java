import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    String rawData;
    ArrayList<String> allWords;

    public Main() {
        rawData = loadFile();
        allWords = getWords();
    }

    public String getRawData() { return rawData; }

    public ArrayList<String> getAllWords() { return allWords; }

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

    public ArrayList<String> correctCase(ArrayList<String> input){ //corrects all words
        ArrayList<String> allWordsCorrectCase = (ArrayList<String>)input.clone();
        for (int i=0; i<allWordsCorrectCase.size(); i++){
            String word = allWordsCorrectCase.get(i);
            if (word.matches("([a-zA-Z]+)")){
                String fixed = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
                allWordsCorrectCase.set(i, fixed);
            }
            if (word.equalsIgnoreCase("Co")){
                allWordsCorrectCase.set(i, "Cookies");
            }
        }
        allWordsCorrectCase.remove("Kies");
        return allWordsCorrectCase;
    }

    public ArrayList<String> getWords(){ //gets all words from raw data
        ArrayList<String> allWords = new ArrayList<>();
        String wordsPattern = "(([a-zA-Z]+)|(\\d[.]\\d{2})|(\\d[/]\\d{2}[/](\\d{4})))";
        //String groupPattern = "((([a-zA-Z]+)|([a-zA-Z]{2}[0][a-zA-Z]{4})){3}(\\d[.]\\d{2})([a-zA-Z]+){3}(\\d[/]\\d{2}[/](\\d{4})))";
        Pattern pat = Pattern.compile(wordsPattern);
        //Pattern groupPat = Pattern.compile(groupPattern);
        Matcher matcher = pat.matcher(rawData);
        while (matcher.find()) {
            allWords.add(matcher.group());
        }
        return correctCase(allWords);
    }

    public static void main(String[] args){
        Main main = new Main();
        ArrayList<String> allWords = main.getAllWords();
        System.out.println(allWords);
        HashMapMaker hashMapMaker = new HashMapMaker(allWords);
        HashMap<String, HashMap<String, Integer>> groceryMap = hashMapMaker.getAllGroceries();
        Integer numOfMissingWords = hashMapMaker.getErrorCounter();
        Formatter formatter = new Formatter();
        formatter.finalPrint(groceryMap, numOfMissingWords);
    }
}
