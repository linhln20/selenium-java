package practices;


//nhập vào chuỗi swiss lấy ra ký tự cuối cùng của chuỗi này là `s`
public class ExtractLast4CharactersOfString {
    public static void main(String[] arg) {
        String str = "fjdkg josd";
        int i = str.length()-1;
        System.out.println(str.charAt(i));
    }
}
