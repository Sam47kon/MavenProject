package GrandTasks.Week9_10;

import java.util.HashSet;
import java.util.Iterator;

public class WorkHashSet1 {
    public static void main(String[] args) {
        CustomHashSet<Integer> my = new CustomHashSet<>();
        CustomHashSet1<Integer> my1 = new CustomHashSet1<>();
        HashSet<Integer> lib = new HashSet<>();

        my.add(1);
        my.add(2);
        my.add(3);

        my1.add(1);
        my1.add(2);
        my1.add(3);

        lib.add(1);
        lib.add(2);
        lib.add(3);

        System.out.println(my.toString());
        System.out.println(my1.toString());
        System.out.println(lib.toString());

        Iterator<Integer> myItr1 = my1.iterator();
        while (myItr1.hasNext()) {
            System.out.println(myItr1.next());
            myItr1.remove();
        }
        System.out.println(my1.toString());
    }
}
