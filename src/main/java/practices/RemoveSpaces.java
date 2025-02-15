package practices;

import java.util.HashMap;
import java.util.Map;

public class RemoveSpaces {
    public static void main (String[] args){
        String str = "Java    is I great     and Java is fun    and Is    Java is     powerful";
        System.out.print(removeWhiteSpace(str));
    }

    private static String removeWhiteSpace(String str){
        String newStr = str.replaceAll("\\s", "");
        return newStr;
    }
}
