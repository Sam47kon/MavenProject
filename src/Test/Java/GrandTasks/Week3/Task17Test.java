package GrandTasks.Week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task17Test {
    private final double X1 = 5.234;
    private final double X2 = 324.21;
    private final double X3 = -32.993;
    private final double X4 = 0;

    @Test
    void testSolutionOfEquation1() {
        Assertions.assertEquals(324.252, new Task17().solutionOfEquation1(X1, X2), 1.0E-03);
        Assertions.assertEquals(32.993, new Task17().solutionOfEquation1(X4, X3), 0);
    }

    @Test
    void testSolutionOfEquation6() {
        Assertions.assertEquals(-1375.185, new Task17().solutionOfEquation6(X1, X2, X2), 1.0E-03); // -1375.185115912916
    }

    @Test
    void testSolutionOfEquation7() {
        Assertions.assertEquals(32.8861, new Task17().solutionOfEquation7(X1), 1E-04);                 // 32.886191897777955
        Assertions.assertEquals(2037.071508, new Task17().solutionOfEquation7(X2), 1E-06);           // 2037.0715084406936
        Assertions.assertEquals(-207.3011, new Task17().solutionOfEquation7(X3), 1E-04);               // -207.3011328397761
        Assertions.assertEquals(0, new Task17().solutionOfEquation7(X4));
    }

    @Test
    void testSolutionOfEquation10() {
        Assertions.assertEquals(0.89981, new Task17().solutionOfEquation10(X1, X2, X3), 1E-05);       // 0.8998178811630841
        Assertions.assertEquals(-225.38182, new Task17().solutionOfEquation10(X2, X3, X1), 1E-05);    //-225.3818219826427
        Assertions.assertEquals(-9.4828E-4, new Task17().solutionOfEquation10(X3, X1, X2), 1E-6);
    }
}