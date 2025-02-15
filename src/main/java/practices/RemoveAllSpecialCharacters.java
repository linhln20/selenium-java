package practices;

public class RemoveAllSpecialCharacters {
        public static void main (String[] args){
            String str = "Hello^^%#$(!)_+ J@apneet and We3(llcome";
            System.out.print(removeSpecialCharacters(str));
        }

        private static String removeSpecialCharacters(String str){
            String newStr = str.replaceAll("[%^#$()!_+@,0-9]", "");
            return newStr;
        }
}
