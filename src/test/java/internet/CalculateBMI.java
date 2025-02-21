package internet;

public class CalculateBMI {

    public static String calculateBmi(double height, double weight){
        double newHeight = height/100;
        double bmi = (weight/(newHeight*newHeight));
        return String.format("%.1f", bmi);
    }
}
