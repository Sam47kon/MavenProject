package StepikTasks.Stepik5.S5_3;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static MyMethods.MyMethods.FOLDER_DESKTOP;
import static MyMethods.MyMethods.getRuntime;

public class Work {

    public static void main(String[] args) throws NoSuchMethodException {
//        question3();
//        question4_writeToFile_US_ASCII();
//        question4_writeToInputStream(System.out, "текст на кириллице", StandardCharsets.UTF_8);
//        question4_writeToFile(StandardCharsets.UTF_8, "записанно с помощью метода, в кодировке UTF-8,  в файл text.txt", "text.txt");

        double runTime = getRuntime(() -> question4_writeToFile(StandardCharsets.UTF_8, "записанно с помощью метода, в кодировке UTF-8,  в файл text.txt", "text.txt"));
        System.out.println(runTime);
        // или
        runTime = getRuntime(Work::question4_writeToFile_Asist);
        System.out.println(runTime);

    }


    private static void question3() {
        Scanner scanner = new Scanner(System.in);
        byte[] bytes;
        boolean exit = false;
        while (!exit) {
            System.out.println("Введите символ:");
            bytes = scanner.nextLine().getBytes(StandardCharsets.UTF_8);
            for (byte b : bytes) {
                System.out.print(Byte.toUnsignedInt(b) + " ");
            }
            System.out.println("\n1 чтобы выйти");
            exit = scanner.nextLine().equals("1");

        }
    }

    private static void question4_writeToFile_US_ASCII() {
        File file = new File(FOLDER_DESKTOP, "text.txt");
        Writer writer = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.US_ASCII);
            writer.write("АБВГД");
            writer.flush();
            writer.close();
            System.out.println("Выполнено");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void question4_writeToInputStream(OutputStream outputStream, String text, Charset charset) {
        try (Writer writer = new OutputStreamWriter(outputStream, charset)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void question4_writeToFile(Charset charset, String textToWrite, String fileToWrite) {
        File file = new File(FOLDER_DESKTOP, fileToWrite);
        Writer writer = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(file), charset);
            writer.write(textToWrite);
            writer.flush();
            writer.close();
            System.out.println("Выполнено");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void question4_writeToFile_Asist() {
        question4_writeToFile(StandardCharsets.UTF_8, "записанно с помощью метода, в кодировке UTF-8,  в файл text.txt", "text.txt");
    }
}
