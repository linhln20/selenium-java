package practices;
import java.util.Arrays;
//7. Đưa các số âm trong mảng lên đầu:
public class MoveNegativeNumbersToStart{
    public static void main (String [] args){
        int [] arr = {-1,2,3,-4,-7,8};
        moveNegativeNumbersTOStart(arr);
    }

    private static void moveNegativeNumbersTOStart(int [] arr) {
        int[] tempArr = new int[arr.length];
        int counter = 0;
        for (int k : arr) {
            if (k < 0) {
                tempArr[counter] = k;
                counter++;
            }
        }

        for (int j : arr) {
            if (j > 0) {
                tempArr[counter] = j;
                counter++;
            }
        }
        System.out.print(Arrays.toString(tempArr));
    }
}
