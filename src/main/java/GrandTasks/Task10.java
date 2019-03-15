package GrandTasks;

import java.util.Scanner;
import java.util.Set;

// Программа принимает с клавиатуры строку, выводит сколько там гласных, а сколько согласных
public class Task10 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Введите любой текст:");
        String inText = reader.nextLine();

        char[] charArrayInText = new Task10().getCharFromText(inText);
        int vowelsQuantity = new Task10().getVowelsQuantity(charArrayInText);
        int consonantsQuantity = new Task10().getConsonantsQuantity(charArrayInText);

        System.out.println("Количество гласных в тексте - " + vowelsQuantity + ", количество согласных - " + consonantsQuantity);
        //System.out.println(charArrayInText);
    }

    public char[] getCharFromText(String inText) {
        char[] charArrayInText = inText.toCharArray();    // преобразуем введеный текст в массив символов
        for (int i = 0; i < charArrayInText.length; i++) {    // переводим в нижний регистр весь массив
            charArrayInText[i] = Character.toLowerCase(charArrayInText[i]);
        }    // работает не правильно, узнать у Гришы что не так
        return charArrayInText;
    }

    public int getConsonantsQuantity(char[] charArrayInText) {
        int consonantsQuantity = 0;    // количество согласных
        Set<Character> consonants = Set.of('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z', 'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ');    // контейнер согласных
        for (int i = 0; i < charArrayInText.length; i++) {     // проверяем каждое значение массива на предмет вхождения в контейнер согласных
            if (consonants.contains(charArrayInText[i])) {
                consonantsQuantity++;
            }
        }
        return consonantsQuantity;
    }

    public int getVowelsQuantity(char[] charArrayInText) {
        int vowelsQuantity = 0;    // количество гласных
        Set<Character> vowels = Set.of('e', 'y', 'u', 'i', 'o', 'а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я');    // контейнер гласных
        for (int i = 0; i < charArrayInText.length; i++) {    // проверяем каждое значение массива на предмет вхождения в контейнер гласных
            if (vowels.contains(charArrayInText[i])) {
                vowelsQuantity++;
            }
        }
        return vowelsQuantity;
    }
}