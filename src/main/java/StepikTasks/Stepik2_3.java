package StepikTasks;

public class Stepik2_3 {

    public static void main(String[] args) {
        doIsPalindrome("11, 22/ 11");
        doIsPalindrome("11, 22/ 12");
    }

    private static void concatenation() {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";

        s1 = "A" + ('\t' + '\u0003');
        s2 = 'A' + "12";
        s3 = 'A' + '1' + "2";
        s4 = "A" + 12;
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }


    private static boolean isPalindrome(String text) {
        StringBuilder st = new StringBuilder(text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase());
        return st.toString().equals(st.reverse().toString());
    }

    private static void doIsPalindrome(String text) {
        System.out.println(isPalindrome(text));
    }
}