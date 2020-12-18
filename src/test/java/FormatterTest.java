import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class FormatterTest {
        Main main;
        ArrayList<String> allWords;
        String rawData;
        Formatter formatter;
        HashMap<String, Integer> hash;
        HashMap<String, HashMap<String, Integer>> homeHash;

        @Before
        public void setup(){
                main = new Main();
                allWords = main.getAllWords();
                rawData = main.getRawData();
                formatter = new Formatter();
                hash = new HashMap<>();
                hash.put("cat", 3);
                hash.put("dog", 1);
                hash.put("people", 2);
                homeHash = new HashMap<>();
                homeHash.put("My Home", hash);
        }

        @Test
        public void testRightAlignString(){
                String expected = "   apple";
                String actual = formatter.rightAlignString("apple");
                Assert.assertEquals(expected, actual);
        }

        @Test
        public void testFormatMe(){
                String expected = "Name:       cat \t \t Seen:   3 times\n" +
                        "Name:       dog \t \t Seen:   1 times\n" +
                        "Name:    people \t \t Seen:   2 times\n" +
                        "--------------- \t \t ---------------\n" +
                        "=============== \t \t ===============\n";
                String actual = formatter.formatMe(hash);
                Assert.assertEquals(expected, actual);
        }

        @Test
        public void testFinalPrint(){
                formatter.finalPrint(homeHash, 0);
        }
}
