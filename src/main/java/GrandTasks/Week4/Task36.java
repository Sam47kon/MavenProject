package GrandTasks.Week4;

// 9.15. Дано слово. Вывести на экран его k-й символ.
class Task36 {

    public static void main(String[] args) {
        System.out.println(new Task36().getSpecificCharaFromString1("123456", 1));
        System.out.println(new Task36().getSpecificCharaFromString1("123456", 2));
        System.out.println(new Task36().getSpecificCharaFromString1("123456", 3));
        System.out.println(new Task36().getSpecificCharaFromString1("123456", 4));
    }

    char getSpecificCharaFromString1(String dataStr, int dataIndex) {
        return dataStr.charAt(dataIndex - 1);
    }
}
