package StepikTasks.Stepik5.S5_4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/StepikTasks/Stepik5/S5_4/NioDemo.java");

        try (ReadableByteChannel in = FileChannel.open(path);
             WritableByteChannel out = Channels.newChannel(System.out)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (in.read(buffer) >= 0 || buffer.position() != 0) {
                buffer.flip();
                out.write(buffer);
                buffer.compact();
            }

        }
    }
}
