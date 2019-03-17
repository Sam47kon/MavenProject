package GrandTasks.Week2;

import java.util.Scanner;
import java.util.Set;

// Программа принимает с клавиатуры строку, выводит сколько там гласных, а сколько согласных
public class Task10v2 {

    public static final Set<Character> VOWELS = Set.of('a', 'e', 'y', 'u', 'i', 'o', 'о', 'и', 'е', 'а', 'ё', 'э', 'ы',
            'у', 'ю', 'я');
    public static final Set<Character> CONSONANTS = Set.of('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p',
            'q', 'r', 's', 't', 'v', 'w', 'x', 'z', 'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р',
            'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ');

    public static void main(String[] args) {
        System.out.println("Введите любой текст:");
        String inputText = new Scanner(System.in).nextLine();

        //region decision v1
        //        long consonantsCount = 0;
//        long vowelsCount = 0;
//        long otherCount = 0;
//        for (int i = 0; i < inputText.length(); i++) {    // пробегаемся по всей длине введенного текста
//            char ch = inputText.charAt(i);    // перезаписываем каждый символ по порядку в переменную c
//            if (new Task10v2().isVowel(ch)) {    // проверяем через метод входит ли значение переменной c в список гласных
//                vowelsCount++;
//            } else if (new Task10v2().isConsonants(ch)) { // проверяем через метод входит ли значение переменной c в список согласных
//                consonantsCount++;
//            } else {
//                otherCount++;
//            }
//        }
//        System.out.println("Количество согласных = " + consonantsCount);
//        System.out.println("Количество гласных = " + vowelsCount);
//        System.out.println("Количество других символов = " + otherCount);
//        System.out.println("Всего символов = " + inputText.length());
        //endregion

        long vowelsCount1 = new Task10v2().getVowelsCount(inputText);
        long consonantsCount1 = new Task10v2().getConsonantsCount(inputText);
        System.out.println("Количество гласных = " + vowelsCount1);
        System.out.println("Количество согласных = " + consonantsCount1);
    }

    public long getConsonantsCount(String inputText) {
        return inputText.chars().filter(ch -> new Task10v2().isConsonants((char) ch)).count();
    }

    public long getVowelsCount(String inputText) {
        return inputText.chars().filter(ch -> new Task10v2().isVowel((char) ch)).count();
    }


    public boolean isConsonants(char ch) {
        return CONSONANTS.contains(Character.toLowerCase(ch));    // возвращает булекское значение метода contains объекта (поступающего знака переведенного в верхний регистр)
    }

    public boolean isVowel(char ch) {
        return VOWELS.contains(Character.toLowerCase(ch));    // возвращает булекское значение метода contains объекта (поступающего знака переведенного в верхний регистр)
    }

}
