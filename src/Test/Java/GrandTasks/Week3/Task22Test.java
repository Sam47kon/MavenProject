package GrandTasks.Week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task22Test { // TODO попробовать в этом классе прописать переменные в теле класса и параметры get set

    @Test
    void testWhichIsLess(){  //  TODO спокойной ночи
        //int =
        //Assertions.assertEquals(0);

    }

    @Test
    void testItIsEvenNumber() {
        int x = 1;
        int y = 2;
        Assertions.assertFalse(new Task22().itIsEvenNumber(x, y));

        x = -60;
        y = 40;
        Assertions.assertTrue(new Task22().itIsEvenNumber(x, y));

        x = -18;
        y = -46;
        Assertions.assertTrue(new Task22().itIsEvenNumber(x, y));

        x = 0;
        y = 0;
        Assertions.assertTrue(new Task22().itIsEvenNumber(x, y));

        x = -7;
        y = 0;
        Assertions.assertFalse(new Task22().itIsEvenNumber(x, y));

    }
}