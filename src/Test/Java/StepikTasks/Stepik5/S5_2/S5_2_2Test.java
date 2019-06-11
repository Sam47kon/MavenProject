package StepikTasks.Stepik5.S5_2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class S5_2_2Test {
    @Test
    void DoNothingIfArrayIsEmpty() throws Exception {
        byte[] inputBytes = {};
        byte[] expectedBytes = {};
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }

    @Test
    void DoNothingIfThereIsNoSpecialCharacters() throws Exception {
        byte[] inputBytes = {1, 2, 3};
        byte[] expectedBytes = {1, 2, 3};
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }

    @Test
    void ReplaceAtLeft() throws Exception {
        byte[] inputBytes = {13, 10, 1, 2, 3, 4, 5, 6};
        byte[] expectedBytes = {10, 1, 2, 3, 4, 5, 6};
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }

    @Test
    void ReplaceAtCenter() throws Exception {
        byte[] inputBytes = {1, 2, 3, 13, 10, 4, 5, 6};
        byte[] expectedBytes = {1, 2, 3, 10, 4, 5, 6};
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }

    @Test
    void ReplaceAtRight() throws Exception {
        byte[] inputBytes = {1, 2, 3, 4, 5, 6, 13, 10};
        byte[] expectedBytes = {1, 2, 3, 4, 5, 6, 10};
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }

    @Test
    void ReplaceOnlyOnce() throws Exception {
        byte[] inputBytes = {1, 2, 3, 13, 13, 10, 4, 5, 6};
        byte[] expectedBytes = {1, 2, 3, 13, 10, 4, 5, 6};
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }

    @Test
    void DoNotReplaceReversedSymbols() throws Exception {
        byte[] inputBytes = {1, 2, 3, 10, 13, 4, 5, 6};
        byte[] expectedBytes = {1, 2, 3, 10, 13, 4, 5, 6};
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }

    @Test
    void ReplaceMultipleMatches() throws Exception {
        byte[] inputBytes = {1, 2, 3, 13, 10, 13, 10, 4, 5, 6};
        byte[] expectedBytes = {1, 2, 3, 10, 10, 4, 5, 6};
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }

    @Test
    void ReplaceMultipleMatchesAtDifferentPlaces() throws Exception {
        byte[] inputBytes = {1, 2, 13, 10, 3, 4, 13, 10, 5, 6};
        byte[] expectedBytes = {1, 2, 10, 3, 4, 10, 5, 6};
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }

    @Test
    void TestDataFromStepic() throws Exception {
        byte[] inputBytes = {65, 13, 10, 10, 13};
        byte[] expectedBytes = {65, 10, 10, 13};
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }

    @Test
    void TestDataFromPilosus() throws Exception {
        byte[] inputBytes = {65, 66, 13, 13, 10, 10, 13, 67, 13, 13};
        byte[] expectedBytes = {65, 66, 13, 10, 10, 13, 67, 13, 13};
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }

    byte[] doTest(byte[] inputBytes) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        S5_2_2.main(null);
        return outputStream.toByteArray();
    }

}