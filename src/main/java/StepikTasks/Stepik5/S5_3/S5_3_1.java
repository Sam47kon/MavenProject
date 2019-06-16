package StepikTasks.Stepik5.S5_3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class S5_3_1 {

    public static void main(String[] args) throws IOException {

        System.out.println(readAsString(System.in, StandardCharsets.UTF_8));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Reader reader = new InputStreamReader(inputStream, charset);
        int i;
        while ((i = reader.read()) != -1) {
            stringBuilder.append(Character.toChars(i));
        }
        return stringBuilder.toString();
    }
}
