package practices;
//9. In ra ký tự đầu tiên của mỗi từ trong một câu:

public class PrintFirstLetterOfString {
    public static void main (String[] args){
        String str = "Practice Java code";
        returnFirstAlphabet(str);
    }

    private static void returnFirstAlphabet(String string){
        String word = "";
        String [] split = string.split(" ");

        for (String i : split) {
            word = i;
            System.out.print(word.charAt(0) + " ");
        }
    }
}
