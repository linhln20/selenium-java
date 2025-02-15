package practices;

import java.util.HashMap;
import java.util.Map;

//Tìm ký tự không lặp lại đầu tiên của một chuỗi
public class FindFirstNonRepeatedCharacter {
    public static void main (String [] args) {
//        String str = "nonrepeatedcharacter";
//        String str = "abcabcsabc";
        String str = "with the number of counts we want to repeat the string";
        findNonRepeatingCharacter(str);
    }
    private static void findNonRepeatingCharacter(String str){
        Map<Character,Integer> map = new HashMap<>();
        int counter = 1;

        for(int i=0; i<str.length(); i++){
            if (map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }
            else {
                map.put(str.charAt(i),counter);
            }
        }

        for (int i=0; i<str.length(); i++){
            if(map.get(str.charAt(i)) == 1){
                System.out.println(str.charAt(i));
                break;
            }
        }
    }
}
