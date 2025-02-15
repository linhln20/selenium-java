package org.example;

public class Bai3Day1 {
    /**
     * create method
     * input String
     * output: boolean
     * objective: check the string contain uppercase character?
     */
//    private static boolean isContainUppercase(String[] args) {
//
//        System.out.println(isContainUppercase("a"));
//        System.out.println(isContainUppercase((String[]) null));
//    }

    //-----------------------------------------------------
    public static boolean isContainUppercase(String str) {
        return str.matches(".*[A-Z].*");
    }
}