package practices;
import java.util.*;

public class RemoveDuplicateWordsFromSentence {
    public static void main (String [] args){
//        String str = "Java is I great and java is fun and Is Java is powerful"; //Result: Java is I great and fun powerful
        String str = "Hello I am Jannet jannet Am"; //Result: Hello I am Jannet
        printSentenceWithoutDuplicates(str);
    }

    private static void printSentenceWithoutDuplicates(String str){
        String strSplit = str.toLowerCase();
        String [] strSplit2 = strSplit.split("\\s");
        String [] strSplit3 = str.split("\\s");

        Map<String, Integer> map = new HashMap<>();
        int counter = 1;

        List<Integer> indexDup = new ArrayList<>();

        for (int s=0; s<strSplit2.length; s++) {
            if (!map.containsKey(strSplit2[s])) {
                map.put(strSplit2[s], counter);
            } else {
                map.put(strSplit2[s], 2);
                indexDup.add(s);
            }
        }

        for (int s=0; s<strSplit3.length; s++) {
            if(indexDup.contains(s)){
                continue;
            }
            System.out.printf(strSplit3[s] + " ");
        }
    }
}
