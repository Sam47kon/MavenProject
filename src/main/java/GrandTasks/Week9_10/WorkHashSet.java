package GrandTasks.Week9_10;

import java.util.Arrays;
import java.util.Iterator;

public class WorkHashSet {
    public static void main(String[] args) {
        CustomHashSet<Integer> myHashSet = new CustomHashSet<>();
        CustomHashSet<Integer> addHashSet = new CustomHashSet<>();

        System.out.println("myHashSet.isEmpty() = " + myHashSet.isEmpty());
        System.out.println("myHashSet.add(1) = " + myHashSet.add(1));
        System.out.println("myHashSet.add(1) = " + myHashSet.add(1));
        System.out.println("myHashSet.size() = " + myHashSet.size());
        System.out.println("adding...");
        for (int i = 0; i < 10; i++) {
            myHashSet.add(i);
        }
        System.out.println("myHashSet.toString() = " + myHashSet.toString());
        System.out.println("myHashSet.size() = " + myHashSet.size());
        System.out.println("myHashSet.isEmpty() = " + myHashSet.isEmpty());
        System.out.println("myHashSet.contains(1) = " + myHashSet.contains(1));
        System.out.println("myHashSet.contains(2) = " + myHashSet.contains(2));
        System.out.println("myHashSet.contains(-1) = " + myHashSet.contains(-1));

        Iterator<Integer> iterator = myHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.print("iterator.next() = " + iterator.next() + ", ");
        }
        System.out.println();
        System.out.println("myHashSet.toArray() = " + Arrays.toString(myHashSet.toArray()));


        System.out.println("myHashSet.toArray(new String[5]) = " + Arrays.toString(myHashSet.toArray(new String[5])));
        System.out.println("myHashSet.toArray(new Integer[5]) = " + Arrays.toString(myHashSet.toArray(new Integer[5])));
        System.out.println("myHashSet.toArray(new Integer[21]) = " + Arrays.toString(myHashSet.toArray(new Integer[21])));

        System.out.println("myHashSet.remove(0) = " + myHashSet.remove(0));
        System.out.println("myHashSet.remove(1) = " + myHashSet.remove(1));
        System.out.println("myHashSet.remove(-1) = " + myHashSet.remove(-1));
        System.out.println("myHashSet.toString() = " + myHashSet.toString());

        System.out.println("myHashSet.containsAll(addHashSet) = " + myHashSet.containsAll(addHashSet));
        System.out.println("addHashSet.containsAll(myHashSet) = " + addHashSet.containsAll(myHashSet));

        System.out.println("addHashSet.addAll(myHashSet) = " + addHashSet.addAll(myHashSet));
        System.out.println("addHashSet.addAll(myHashSet) = " + addHashSet.addAll(myHashSet));
        System.out.println("addHashSet.containsAll(myHashSet) = " + addHashSet.containsAll(myHashSet));
        System.out.println("addHashSet.toString() = " + addHashSet.toString());

        System.out.println("myHashSet.retainAll(addHashSet) = " + myHashSet.retainAll(addHashSet));
        System.out.println("myHashSet.add(55) = " + myHashSet.add(55));
        System.out.println(myHashSet.toString());
        System.out.println(addHashSet.toString());
        System.out.println("myHashSet.retainAll(addHashSet) = " + myHashSet.retainAll(addHashSet));
        System.out.println(myHashSet.toString());
        System.out.println(addHashSet.toString());

        System.out.println("myHashSet.removeAll(addHashSet) = " + myHashSet.removeAll(addHashSet));
        System.out.println(myHashSet.toString());

    }


    static int hash(Object key) {
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    static int index(int size, int hash) {
        return (size - 1) & hash;
    }
}
