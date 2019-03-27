package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task36Test {

    @Test
    void testGetSpecificCharaFromString1() {
        Assertions.assertEquals('h', new Task36().getSpecificCharaFromString1("asdfghjkl", 6));
        Assertions.assertEquals(' ', new Task36().getSpecificCharaFromString1("Hallo World", 6));
        Assertions.assertEquals('W', new Task36().getSpecificCharaFromString1("Hallo World", 7));
    }
}