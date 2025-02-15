package org.example;

public class Bai2Day1 {
        //add a given string without using "+"
        //vi du "Ha", "Do" ==> "Ha Do"
        public static void main(String[] args) {

            String name = String.format("%s %s", "Ha", "Do");
        //Cách 1
            System.out.println(name);
        //Cách 2
            System.out.printf("%s %s", "Ha", "Do");

        }
}
