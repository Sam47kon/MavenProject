package GrandTasks.Week3;

// В трехзначном числе x зачеркнули его вторую цифру. Когда к образованному
// при этом двузначному числу справа приписали вторую цифру числа x, то получилось число n.
// По заданному n найти число x (значение n вводится с клавиатуры, 100 ≤ n ≤ 999).
public class Task18 {

    public static void main(String[] args) {
        int inputNumber;
        boolean falseNumber;
        do {
            inputNumber = (int) new Task16().getDoubleFromInput("Введите число от 100 до 999");
            falseNumber = inputNumber <= 100 || inputNumber >= 999;
            if (falseNumber) {
                System.out.println("Число от 100 до 999!!!");
            }
        }
        while (falseNumber);
        System.out.println(new Task18().findX(inputNumber));
    }

    // дано: целое число x1x2x3, где х это индекс (трехзначное число), x1x3x2==n, где n целое трехзначное число
    public int findX(int n) {
//        int x1 = n / 100 * 100;       // x1=n1=n1n2n3/100 (сотня)
//        int x2 = n % 10 * 10;        // x2=n3=n1n2n3%10 *10 (десяток)
//        int x3 = (n / 10) % 10;   // x3=n2=(n1n2n3/10)%10 *100 (единица)
//        return x1 + x2 + x3;
        return n / 100 * 100 + n % 10 * 10 + (n / 10) % 10;
    }
}
