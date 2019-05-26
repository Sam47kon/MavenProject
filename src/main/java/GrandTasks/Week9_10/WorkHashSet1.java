package GrandTasks.Week9_10;

import java.util.HashSet;
import java.util.Iterator;

public class WorkHashSet1 {
    public static void main(String[] args) {
        CustomHashSet<Integer> my = new CustomHashSet<>();
        HashSet<Integer> lib = new HashSet<>();

        my.add(1);
        my.add(2);
        my.add(3);

        lib.add(3);
        lib.add(4);
        lib.add(5);

        System.out.println(my.toString());
        System.out.println(lib.toString());

        Iterator<Integer> myItr = my.iterator();
        while (myItr.hasNext()) {
            myItr.next();
            myItr.remove();
        }
        System.out.println(my.toString());



    }
}
