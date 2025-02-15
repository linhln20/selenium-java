package practices;

public class ReverseString {
        public static void main (String[] args){
            String str = "MOuntain pigEons are four species of birds";
            printReverseofString(str);
        }

        private static void printReverseofString (String str){
            String reverse = new StringBuffer(str).reverse().toString();
            System.out.println(reverse);
        }
    }
