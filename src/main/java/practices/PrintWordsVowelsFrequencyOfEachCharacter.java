package practices;

public class PrintWordsVowelsFrequencyOfEachCharacter {

    public static void main(String[] args) {

        String str= "MOuntain pigEons are four species of birds";
        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;

        for (int x = 0; x < str.length(); x++) {
            int placesInString = 0;
            if (str.charAt(x) == 'e'|| str.charAt(x) == 'E') {
                e++;
            } else if (str.charAt(x) == 'i'|| str.charAt(x) == 'I') {
                i++;
            } else if (str.charAt(x) == 'o'|| str.charAt(x) == 'O') {
                o++;
            } else if (str.charAt(x) == 'u'|| str.charAt(x) == 'U') {
                u++;
            } else if (str.charAt(x) == 'a'||str.charAt(x) =='A') {
                a++;
            }
        }
        System.out.println("Numbber of 'u' in string: " + u);
        System.out.println("Numbber of 'e' in string: " + e);
        System.out.println("Numbber of 'o' in string: " + o);
        System.out.println("Numbber of 'a' in string: " + a);
        System.out.println("Numbber of 'i' in string: " + i);
    }
}
