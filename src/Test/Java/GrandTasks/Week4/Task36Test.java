package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task36Test {

    @Test
    void getSpecificCharaFromString() {
        Assertions.assertEquals('h', new Task36().getSpecificCharaFromString("asdfghjkl", 6));
        Assertions.assertEquals(' ', new Task36().getSpecificCharaFromString("Hallo World", 6));
    }
}