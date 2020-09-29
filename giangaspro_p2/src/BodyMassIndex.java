public class BodyMassIndex {
    public static String category;
    public static double score;
    public BodyMassIndex(double height, double weight) {
        score = calculateScore(height, weight);
        category = determineCategory(score);
    }
    public static double calculateScore (double height, double weight) {
        return (703*weight)/(height*height);
    }
    public static String determineCategory (double score) {
        if(score<18.5) {return "Underweight";}
        if(score>=18.5 && score<24.9) {return "Normal";}
        if(score>=25 && score<29.9) {return "Overweight";}
        if(score>=30) {return "Obesity";}
        return "No value";
    }
}
