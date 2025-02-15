package practices;

public class FindMaximumDifference {
    //Tìm độ lệch lớn nhất giữa 2 phần tử trong một mảng:
        public static void main (String [] args){
            int [] arr = {10,90,2,40,1,25};
            printMaximumDifference(arr);
        }

        private static void printMaximumDifference(int [] arr){
            int max = arr[0];
            int min = arr[0];

            for(int j : arr){
                if(j > max){
                    max = j;
                }
                else if (j < min){
                    min = j;
                }
            }
            System.out.print("Max Difference is: "+ (max-min));
        }

//            for(int i=0; i<arr.length; i++){
//                if(arr[i] > max){
//                    max = arr[i];
//                }else if (arr[i] < min){
//                    min = arr[i];
//                }
//            }
    }

