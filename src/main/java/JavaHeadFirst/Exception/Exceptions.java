package JavaHeadFirst.Exception;

public class Exceptions {
    public static void main(String[] args) {
        int[] arr = new int[5];
        try {  // пробовать
            System.out.println(arr[6]);
        } catch (Exception e) {  // обрабатывать - ловить исключение (вид придумать имя) {что делать}
            System.out.println("An error occurred"); // произошла ошибка
        }
        System.out.println("это выполниться");
    }

    int division(int a, int b) throws ArithmeticException { // математические исключения, можно перечислять через запятую
        if (b == 0) {
            throw new ArithmeticException("Деление на 0");  // указываю что параметр b=0 вызывает исключение
        } else return a / b;
    }
}
