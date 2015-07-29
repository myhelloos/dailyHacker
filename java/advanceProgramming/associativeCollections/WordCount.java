package associativeCollections;

import java.util.TreeMap;
import java.util.*;

public class WordCount {
public static void main(String[] args) {
        String text;
        text = "Either the well was very deep or she fell very slowly "
               + "for she had plenty of time as she went down to look about "
               + "her and to what was going to happen next First "
               + "she tried to look down and make out what she was coming to "
               + "but it was too dark to see anything then she looked at the "
               + "sides of the well and noticed that they were filled with "
               + "cupboards and book-shelves here and there she saw maps and "
               + "pictures hung upon pegs She took down a jar from one of the  "
               + "shelves as she passed it was labeled orange marmalade but "
               + "to her great disappointment it was empty she did not like to "
               + "drop the jar for fear of killing somebody underneath so "
               + "managed to put it into one of the cupboards as she fell past";
        String[] words = text.split(" ");
        Arrays.sort(words);
        int count = 0;
        for (String word : words) {
                System.out.println("Word: " + word);
        }
        TreeMap<String, Integer> wordList = new TreeMap<>();
        String thisWord = "";
        String nextWord = "";
        for (int i=0; i<words.length-1; i++) {
                thisWord = words[i];
                nextWord = words[i+1];
                count++;
                if (!thisWord.equals(nextWord)) {
                        wordList.put(thisWord, count);
                        count = 0;
                }
        }
        // handling odd word list count
        if (words.length % 2 == 0) {
                nextWord = words[words.length - 1];
                if (!thisWord.equals(nextWord)) {
                        count++;
                } else {
                        count = 1;
                }
                wordList.put(nextWord, count);
        }
        for (Map.Entry<?,?> entry : wordList.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
        }
}
}
