package StepikTasks;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Stepik1_3 {

    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest("abracadabra".getBytes(StandardCharsets.UTF_8));
        for (byte b : digest) {
            System.out.printf("%02x", b);
        }
    }
}
