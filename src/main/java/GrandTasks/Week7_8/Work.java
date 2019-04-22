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


        System.out.println("getFirstElement: " + myCustomList.getFirstElement());
        System.out.println("myCustomList toArray" + Arrays.toString(myCustomList.toArray()));
        System.out.println("getSize: " + myCustomList.size());
        System.out.println("getLastElement: " + myCustomList.getLastElement());

    }
}
