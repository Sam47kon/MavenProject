package MyStaticMethods;

import java.util.Scanner;

public class TMP_Main {

    public static void main(String[] args) {
        solution3();
    }

    static int solveMeFirst(int a, int b) {
        return a + b;
    }

    static void soutprintln(int i) {
        if (i % 2 == 1 || (i >= 6 && i <= 20)) {
            System.out.println("Weird");
        } else System.out.println("Not Weird");
    }

    static void solution3() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        double d = sc.nextDouble();
        sc.nextLine();
        String s = sc.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
