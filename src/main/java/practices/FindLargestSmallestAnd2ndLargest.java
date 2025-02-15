package practices;

//Tìm số lớn nhất và lớn thứ 2 của một mảng

import java.util.Arrays;

public class FindLargestSmallestAnd2ndLargest{
    public static void main (String[] args){
        int [] arr = {23,5,1,89,65,0,23,432,1};
        printLargest2ndLargestAndSmallest(arr);
    }

    private static void printLargest2ndLargestAndSmallest(int [] arr){
        int largest = arr[0];
        int secondLargest = arr[0];
        int smallest = arr[0];

        for (int j : arr) {
            if (j > largest) {
                secondLargest = largest;
                largest = j;
            } else if (j < smallest) {
                smallest = j;
            }
        }
        System.out.printf("Largest is %d" +
                "\nSecond Largest is %d" +
                "\nSmallest is %d",
                largest, secondLargest, smallest);
    }

}