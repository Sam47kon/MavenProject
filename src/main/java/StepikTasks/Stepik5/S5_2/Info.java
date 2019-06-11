package StepikTasks.Stepik5.S5_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Info {

    public static void main(String[] args) {
//        classStream();
//        siteStream("ya.ru");
//        siteStream("ya.com");
//        siteStream("vk.com");

    }

    private static void siteStream(String site) {
        try (Socket socket = new Socket(site, 80)) {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("GET / HTTP/1.1\r\n\r\n".getBytes());
            outputStream.flush();

            InputStream inputStream = socket.getInputStream();
            int read = inputStream.read();
            while (read >= 0) {
                System.out.print((char) read);
                read = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void classStream() {
        int length = 0;
        try (InputStream inputStream = Info.class.getResourceAsStream("Info.class")) {
            int read = inputStream.read();
            while (read >= 0) {
                length++;
                System.out.printf("%02x ", read);
//                System.out.print((char) read + "");
//                System.out.println(read);
                read = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n" + length);
    }
}
