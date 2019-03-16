package GrandTasks;

// Программа принимает с клавиатуры число, и определяет, является ли это число степенью двойки
public class Task11 {

    public static void main(String[] args) {
        int inputNum = (int) new Task5().getNumber();
        new Task11().isNumberPowerOfTwo1(inputNum);    // 1 вариант
        new Task11().isNumberPowerOfTwo2(inputNum);    // 2 вариант
    }

    public boolean isNumberPowerOfTwo1(int inputNum) {
        while (((inputNum % 2) == 0) && inputNum > 0) {
            inputNum /= 2;
        }
        if (inputNum == 1) {
            System.out.println("YES");
            return true;
        }
        System.out.println("NO");
        return false;
    }

    public boolean isNumberPowerOfTwo2(int inputNum) {
        if ((inputNum & (-inputNum)) == inputNum && inputNum != 0) {
            System.out.println("Ваше число " + inputNum + " является степенью двойки");
            return true;
        } else {
            System.out.println("Число " + inputNum + " НЕ является степенью двойки");
            return false;
        }
    }

    //region Для меня, для расчетов
//    public void printUsefulInfo() {
//        int inputNum = (int) new Task5().getNumber();
//        System.out.println("наше число " + inputNum);
//        System.out.println(("наше число противоположное: " + ~(inputNum - 1)));    // эквивалентно -inputNumber
//        System.out.println("двоичное число " + Integer.toBinaryString(inputNum));
//        System.out.println("двоичное число противоположное: " + Integer.toBinaryString(~(inputNum - 1)));    // эквивалентно -inputNumber
//    }
    //endregion

    //region Вывод чисел от 0-64 в двоичнйой системе
    //    public String outNumbersInBinary() {
//        int[] numbersInDecimal = new int[65];
//        String[] numbersInBinary = new String[65];
//        for (int i = 0; i < numbersInDecimal.length; i++) {
//            numbersInDecimal[i] = i;
//            numbersInBinary[i] = Integer.toBinaryString(numbersInDecimal[i]);
//        }
//        return Arrays.toString(numbersInBinary);
//    }
    //endregion
}
