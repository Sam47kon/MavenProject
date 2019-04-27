package GrandTasks.Week7_8;

import GrandTasks.Week5_6.CustomArrayList;

import java.util.Arrays;
import java.util.Collection;

public class Work {

    public static void main(String[] args) {
        CustomLinkedListGeneric myCustomList = new CustomLinkedListGeneric();
        Collection collection = new CustomArrayList();
        myCustomList.add(1);
        myCustomList.add(2);
        myCustomList.add(3);
        collection.addAll(myCustomList);

        myCustomList.add(0, 11);
        myCustomList.add(1, 111);
        myCustomList.add(5, 4);
        myCustomList.add(3, 333);

        System.out.println("myCustomList toArray" + Arrays.toString(myCustomList.toArray()));
        System.out.println("myCustomList toString " + myCustomList.toString());
        System.out.println("myCustomList indexOf 11 " + myCustomList.indexOf(11));

        System.out.println("getSize: " + myCustomList.size());
        System.out.println("getFirstElement: " + myCustomList.getFirstElement());
        System.out.println("getLastElement: " + myCustomList.getLastElement());

        for (int i = myCustomList.size(); i >= 0; i--) {
            myCustomList.removeFirst();
        }
        System.out.println("\nmyCustomList removeFirst Size times " + myCustomList.toString());

        for (int i = 0; i < 10; i++) {
            myCustomList.add(i);
        }

        for (int i = myCustomList.size(); i >= 0; i--) {
            myCustomList.removeLast();
        }
        System.out.println("myCustomList removeLast Size times " + myCustomList.toString());


        for (int i = 1; i < 11; i++) {
            myCustomList.add(i);
        }
        System.out.println("\nmyCustomList toArray     " + myCustomList.toString());
        myCustomList.removeFirst();
        System.out.println("myCustomList removeFirst " + myCustomList.toString());
        myCustomList.removeLast();
        System.out.println("myCustomList removeLast  " + myCustomList.toString());

        myCustomList.remove(Integer.valueOf(2));
        System.out.println("myCustomList remove 2  " + myCustomList.toString());

        myCustomList.remove(0);
        System.out.println("myCustomList remove i0 " + myCustomList.toString());

        myCustomList.clear();
        System.out.println("myCustomList clear " + myCustomList.toString());

        myCustomList.addAll(collection);
        System.out.println("myCustomList addAll " + myCustomList.toString());

        myCustomList.addAll(1, collection);
        System.out.println("myCustomList addAll " + myCustomList.toString()); // [1 <-> 1 <-> 2 <-> 3 <-> 2 <-> 3]
        System.out.println("myCustomList lastIndexOf 2: " + myCustomList.lastIndexOf(2));

        System.out.println("myCustomList.get(0): " + myCustomList.get(0));
        System.out.println("myCustomList.get(1): " + myCustomList.get(2));
        System.out.println("myCustomList.get(5): " + myCustomList.get(5));

        myCustomList.set(1, 999);
        System.out.println("myCustomList toString " + myCustomList.toString());
        myCustomList.removeAll(collection);
        System.out.println("myCustomList toString " + myCustomList.toString());
        System.out.println("getSize: " + myCustomList.size());

    }
}
