package StepikTasks.Stepik6.S6_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class S6_4_3 {
    public static void main(String[] args) throws IOException {
//        List<String> result = new ArrayList<>();
//        String text = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))  // считываем текст из System.in
//                .readLine().toLowerCase();  // переводим в нижний регистр
//
//        Map<String, Long> map = Arrays.stream(text.split("[^\\p{L}\\p{Digit}_]+")) // 2 вариант, разделение всех слов и получение потока
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));    // создание мапы из объектов стрима с ключем их количества
//
//        map.entrySet().stream().sorted(
//                Map.Entry.<String, Long>comparingByValue().reversed() // сортируем колличества (Map(value)) по убыванию (чтобы после поставить лимит 10)
//                        .thenComparing(Map.Entry.comparingByKey()))
//                .limit(10)  // устанавливаем лимит "эксклюзивных слов" на 10
//                .forEachOrdered(stringLongEntry -> result.add(stringLongEntry.getKey())); // forEachOrdered для сохранения порядка потока
//
//        result.forEach(System.out::println);

        solution();
    }


    private static void solution() throws IOException {

        Arrays.stream(new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))  // считываем текст из System.in
                .readLine().toLowerCase().split("[^\\p{L}\\p{Digit}_]+")) // 2 вариант, разделение всех слов и получение потока
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                entrySet().stream().sorted(
                Map.Entry.<String, Long>comparingByValue().reversed() // сортируем колличества (Map(value)) по убыванию (чтобы после поставить лимит 10)
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(10)  // устанавливаем лимит "эксклюзивных слов" на 10
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

    }
}
