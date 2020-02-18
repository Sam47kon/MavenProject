package StepikTasks.Stepik2;

public class Stepik2_2 {
    public static void main(String[] args) {
        System.out.println(Stepik2_2.charExpression(0, '\\'));
        System.out.println(Stepik2_2.charExpression(1, '\\'));
    }

    public static char charExpression(int a, char ch) {
        return (char) (ch + a);
    }

    boolean isNumberPowerOfTwo1(int inputNum) {
        if (inputNum == 0) {
            return false;
        }
        inputNum = Math.abs(inputNum);
        while (((inputNum % 2) == 0)) {
            inputNum /= 2;
        }
        return inputNum == 1;
    }

    boolean isNumberPowerOfTwo2(int inputNum) {
        inputNum = Math.abs(inputNum);
        return (inputNum & (-inputNum)) == inputNum && inputNum != 0;
    }

    boolean isNumberPowerOfTwo3(int inputNum) {
        return Integer.bitCount(Math.abs(inputNum)) == 1;
    }
}
