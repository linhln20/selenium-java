package org.example;

import static java.lang.Integer.parseInt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        /*

         * input "$50.00"

         * ==> convert to int/float (50/50.00)

         */
        String price = "$50.00";
        //Code 1

        int position = price.indexOf(".");

        String formatted_price = price.substring(1, position);

        int int_price = parseInt(formatted_price);

        float float_price = Float.parseFloat(formatted_price);

        System.out.println(int_price);

        System.out.printf("%.2f", float_price);

    }

    public static boolean isValidPassword(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^(?=.*?[A-Z]) (?=.*?[a-z]) (?=.*?[0-9])(?=.*?[?@#$%^&*]).{9,}$");

    }
}



