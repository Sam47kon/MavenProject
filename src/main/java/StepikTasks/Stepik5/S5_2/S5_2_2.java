package StepikTasks.Stepik5.S5_2;

import java.io.*;

public class S5_2_2 {
    public static void main(String[] args) throws IOException {
        convertToUnix();
    }

    private static void convertToUnix() throws IOException {
        try (InputStream inputStream = System.in) {
            int prev;
            int current = -1;

            do {
                prev = current;
                current = inputStream.read();
                if (prev == 13 && current == 10) {
                    continue;
                } else if (prev >= 0) {
                    System.out.write(prev);
                    System.out.flush();
                }
            } while (current != -1);
        }
    }
}
