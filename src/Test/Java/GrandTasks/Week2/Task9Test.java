package GrandTasks.Week2;

import GrandTasks.Week2.Task9;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task9Test {

    @Test
    void getLineBackwards() {
        String text1 = "123456789qwertyu";
        String text2 = "erkgnr  & &* ^9 2 4 0 9";
        Assertions.assertEquals("uytrewq987654321", new Task9().printLineBackwards(text1));
        Assertions.assertEquals("9 0 4 2 9^ *& &  rngkre", new Task9().printLineBackwards(text2));
    }
}