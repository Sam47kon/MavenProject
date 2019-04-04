package GrandTasks.Week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task22Test {

    @Test
    void testItIsEvenNumber() {
        Assertions.assertFalse(new Task22().itIsEvenNumber(1, 2));
        Assertions.assertTrue(new Task22().itIsEvenNumber(-60, 40));
        Assertions.assertTrue(new Task22().itIsEvenNumber(-18, -46));
        Assertions.assertTrue(new Task22().itIsEvenNumber(0, 0));
        Assertions.assertFalse(new Task22().itIsEvenNumber(-7, 0));
    }

    @Test
    void testItIsUnEvenNumber() {
        Assertions.assertTrue(new Task22().itIsUnEvenNumber(7, 9));
        Assertions.assertFalse(new Task22().itIsUnEvenNumber(8, 9));
        Assertions.assertFalse(new Task22().itIsUnEvenNumber(7, 6));
    }


    @Test
    void testWhichIsLessThanTheIndicator() {
        Assertions.assertFalse(new Task22().whichIsLessThanTheIndicator(50, 30, 60));
        Assertions.assertFalse(new Task22().whichIsLessThanTheIndicator(30, 50, 60));
        Assertions.assertFalse(new Task22().whichIsLessThanTheIndicator(50, 30, 10));
        Assertions.assertFalse(new Task22().whichIsLessThanTheIndicator(-90, -20, 0));
        Assertions.assertTrue(new Task22().whichIsLessThanTheIndicator(99, 12, 13));
        Assertions.assertTrue(new Task22().whichIsLessThanTheIndicator(15, 66, 66));

    }

    @Test
    void testIsZero() {
        Assertions.assertTrue(new Task22().isZero(0, 99));
        Assertions.assertTrue(new Task22().isZero(85, 0));
        Assertions.assertTrue(new Task22().isZero(0, 0));
        Assertions.assertFalse(new Task22().isZero(1, 2));
        Assertions.assertFalse(new Task22().isZero(3, -9));
    }

    @Test
    void testAreAllNumbersNegative() {
        Assertions.assertFalse(new Task22().areAllNumbersNegative(0, 0, 0));
        Assertions.assertFalse(new Task22().areAllNumbersNegative(-6, -9, 0));
        Assertions.assertFalse(new Task22().areAllNumbersNegative(-90, 6, -30));
        Assertions.assertFalse(new Task22().areAllNumbersNegative(-5, 6, 4));
        Assertions.assertFalse(new Task22().areAllNumbersNegative(5, -6, -5));
        Assertions.assertTrue(new Task22().areAllNumbersNegative(-5, -6, -5));
    }

    @Test
    void testOneOfThNumbersIsAMultipleOfFive() {
        Assertions.assertFalse(new Task22().oneOfThNumbersIsAMultipleOfFive(5, 5, 6));
        Assertions.assertFalse(new Task22().oneOfThNumbersIsAMultipleOfFive(5, 5, 5));
        Assertions.assertFalse(new Task22().oneOfThNumbersIsAMultipleOfFive(99, 5, 5));
        Assertions.assertTrue(new Task22().oneOfThNumbersIsAMultipleOfFive(99, 49, 5));
        Assertions.assertTrue(new Task22().oneOfThNumbersIsAMultipleOfFive(15, 49, 59));
        Assertions.assertTrue(new Task22().oneOfThNumbersIsAMultipleOfFive(96, 50, -63));
    }

    @Test
    void testIsOneOfTheNumbersIsOverAHundred() {
        Assertions.assertTrue(new Task22().isOneOfTheNumbersIsOverAHundred(101, 77, 23));
        Assertions.assertTrue(new Task22().isOneOfTheNumbersIsOverAHundred(99, 455, 23));
        Assertions.assertTrue(new Task22().isOneOfTheNumbersIsOverAHundred(0, 77, 999));
        Assertions.assertFalse(new Task22().isOneOfTheNumbersIsOverAHundred(5, 6, 9));
    }
}