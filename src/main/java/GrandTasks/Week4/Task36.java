package GrandTasks.Week4;

// 9.15. Дано слово. Вывести на экран его k-й символ.
class Task36 {
    char getSpecificCharaFromString(String dataStr, int dataIndex) {
        char[] specificChar = dataStr.toCharArray();
        return specificChar[dataIndex - 1];
    }
}
