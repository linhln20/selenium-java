package practices;

public class ChangeSpecialCharacter {
    public static void main (String[] args){
        String str = "Hello @Japneet";
        System.out.println(str);
    }
    private static String StringDifferenceCharacter (String str){
        return str.replace ("@", "_");
    }
}
