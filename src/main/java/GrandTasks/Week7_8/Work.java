package GrandTasks.Week7_8;

import java.util.Arrays;

public class Work {
    public static void main(String[] args) {
        CustomLinkedList myCustomList = new CustomLinkedList();
        myCustomList.add(1);
        myCustomList.add(2);
        myCustomList.add(3);

        myCustomList.add(0, 11);
        myCustomList.add(1, 111);
        myCustomList.add(5, 4);


        System.out.println("myCustomList toArray" + Arrays.toString(myCustomList.toArray()));
        System.out.println("myCustomList toString " + myCustomList.toString());

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

        myCustomList.remove(2);
        System.out.println("myCustomList remove i2 " + myCustomList.toString());

        myCustomList.clear();
        System.out.println("myCustomList clear " + myCustomList.toString());

    }
}
