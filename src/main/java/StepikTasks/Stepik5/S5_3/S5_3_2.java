package StepikTasks.Stepik5.S5_3;


public class S5_3_2 {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double sum = 0;
        while (scanner.hasNext()) {
            try {
                sum += Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
            }
        }
        System.out.format("%.6f", sum);
    }
}