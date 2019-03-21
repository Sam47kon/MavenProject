package GrandTasks.Week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task10v2Test {

    @Test
    void testGetConsonantsAndVowelsCount() {
        String text = "123qweQWEasd 123fdg 564+324";
        Assertions.assertEquals(9, new Task10v2().getConsonantsCount(text));
        Assertions.assertEquals(3, new Task10v2().getVowelsCount(text));
    }
}
