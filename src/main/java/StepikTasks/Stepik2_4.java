package StepikTasks;

import java.math.BigInteger;
import java.util.Arrays;

public class Stepik2_4 {

    public static void main(String[] args) {
        String[] roles = {
                "Городничий", "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        doPrintTextPerRole(roles, textLines);
    }

    private static BigInteger factorial(int value) {
        BigInteger result = BigInteger.ONE; // факториал 0 будет 1, как и должно быть
        for (int i = 1; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }


    private static int[] mergeArrays(int[] a1, int[] a2) {
        System.out.println("A1 =" + Arrays.toString(a1));
        System.out.println("A2 =" + Arrays.toString(a2));
        int[] a3 = new int[a1.length + a2.length];
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < a3.length; i++) {
            if (index1 >= a1.length) {
                a3[i] = a2[index2++];
            } else if (index2 >= a2.length) {
                a3[i] = a1[index1++];
            } else if (a2[index2] >= a1[index1]) {
                a3[i] = a1[index1++];
            } else if (a1[index1] >= a2[index2]) {
                a3[i] = a2[index2++];
            }
        }
        return a3;
    }

    private static void doMergeArrays(int[] a1, int[] a2) {
        int[] a3 = mergeArrays(a1, a2);
        System.out.println(Arrays.toString(a3));
    }


    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder sb = new StringBuilder();
        for (String role : roles) {
            sb.append(role).append(":\n");
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(role + ":")) {
                    sb.append(textLines[i].replaceFirst(role + ":", i + 1 + ")")).append("\n");
                }
            }
        }
        return sb.toString();
    }

    private static void doPrintTextPerRole(String[] roles, String[] textLines) {
        System.out.println(printTextPerRole(roles, textLines));
    }

}
