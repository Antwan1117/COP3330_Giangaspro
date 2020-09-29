import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static double sum;
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
    public static boolean moreInput () {
        Scanner sc = new Scanner(System.in);

        String choice = "Y";

        System.out.println("Would you like to add another user? (Enter Y/N)");
        choice = sc.next();
        sc.nextLine();

        if (choice.equalsIgnoreCase("Y")) {return true;}
        if (choice.equalsIgnoreCase("N")) {return false;}
        else {return false;}
    }
    public static double getUserHeight () {
        Scanner sc = new Scanner(System.in);

        double height = 0;

        System.out.println("Enter the user's height in inches:");
        height = sc.nextDouble();
        sc.nextLine();

        while (height<0) {
            System.out.println("Invalid entry! Must be a positive number, try again:");
            height = sc.nextDouble();
            sc.nextLine();
        }

        return height;
    }
    public static double getUserWeight() {
        Scanner sc = new Scanner(System.in);

        double weight = 0;

        System.out.println("Enter the user's weight in pounds:");
        weight = sc.nextDouble();
        sc.nextLine();

        while (weight<0) {
            System.out.println("Invalid entry! Must be a positive number, try again:");
            weight = sc.nextDouble();
            sc.nextLine();
        }

        return weight;
    }
    public static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.printf("User BMI: %3.1f\n", bmi.score);
        System.out.println(bmi.category);
        sum = sum + bmi.score;
    }
    public static void displayBmiStatistics(ArrayList <BodyMassIndex> bmiData) {
        double avg = (sum/bmiData.size());
        System.out.printf("Average BMI score: %3.1f", avg);
    }
}
