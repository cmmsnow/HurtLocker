import java.util.ArrayList;
import java.util.HashMap;

public class HashMapMaker {

    public HashMapMaker(ArrayList<String> allWords) {

    }

    public HashMap<String, String> createMap(){ //converts list of all formatted strings into map
        HashMap<String, String> fullMap = new HashMap<>();
        //calls formatMe()
        //loop: go through list + confirm pair exists
        //if value does not exist for key, place value in map as "". <- use counter to count # of times
        return fullMap;
    }

    //need "getOccurencesOfWordIn-MAP" ?
    public Integer getOccurencesOfWordInList(ArrayList<String> inputList, String inputWord){
        Integer counter = 0;
        for (String w : inputList){
            if (w.equalsIgnoreCase(inputWord)){
                counter++;
            }
        }
        return counter;
    }
}
