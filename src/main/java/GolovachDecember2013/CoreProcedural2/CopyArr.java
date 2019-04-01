package GolovachDecember2013.CoreProcedural2;

import java.util.Arrays;

import static GolovachDecember2013.CoreProcedural2.Sortings.RuntimeSortings.ARR0;

public class CopyArr {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ARR0));
        System.arraycopy(ARR0, 1, ARR0, 2, 5);
        System.out.println(Arrays.toString(ARR0));
    }
}
