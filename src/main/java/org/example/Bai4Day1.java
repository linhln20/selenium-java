package org.example;

public class Bai4Day1 {
    /**
     * create method check valid password
     * input String
     * output: boolean
     * objective:
     * check the string contain uppercase character
     * check the string contain lowercase character
     * check the string contain number character
     * check the string contain special character: !@#$%^&*
     * --Length> 8
     */
//    private static boolean validatePassWord (String pass) {
//    if(pass == null || pass.isEmpty()) return false;
//    if(pass.length() < 8){
//        return false;
//        }
//        else
//        {
//        return pass.matches(".*[!@#$%^&*]*.");
//        }
//    }
    private static boolean isValidPassword(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^(?=.*?[A-Z]) (?=.*?[a-z]) (?=.*?[0-9])(?=.*?[?@#$%^&*]).{8,}$");
//        System.out.println(isValidPassword("abA$12arbc")); //valid
//        System.out.println(isValidPassword(null)); // check empty
//        System.out.println(isValidPassword ("abA$12c")); // check length < 8
//        System.out.println(isValidPassword("12345$abc")); // check is missing upper character
//        System.out.println(isValidPassword ("12345$ABC")); // check is missing lower character
//        System.out.println(isValidPassword ("abcAabcd$")); // check is missing number
//        System.out.println(isValidPassword("abcAabc12")); // check is missing special character
    }

}