package StepikTasks.Stepik5.S5_2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class S5_2_1 {
    public static void main(String[] args) throws IOException {
        InputStream stream = getStream(new byte[]{0x33, 0x45, 0x01});   // result 71
        int result = checkSumOfStream(stream);
        System.out.print(result);
    }

    public static InputStream getStream(byte[] data) {
        return new ByteArrayInputStream(data);
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int read;
        int result = 0;
        byte[] readBytes = new byte[1024];
        try {
            while ((read = inputStream.read()) != -1) {
                result = Integer.rotateLeft(result, 1) ^ Byte.toUnsignedInt((byte) read);
            }
        } catch (IOException e) {
            throw e;
        }
        return result;
    }
}
