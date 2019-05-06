import GrandTasks.Week5_6.CustomArrayListGeneric;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Программа для вывода
 *
 * @author Sam47kon
 * @version 1.0
 */
public class WorkingClass {
    /**
     * Программа для вывода
     *
     * @param args команды линейных аргументов
     */

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(11);
        arrayList.add(22);
        arrayList.add(33);
        arrayList.add(44);

        CustomArrayListGeneric<Integer> myList = new CustomArrayListGeneric<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.addAll(arrayList);
        arrayList.add(0, 4);
        arrayList.add(0, 3);
        arrayList.add(0, 2);
        arrayList.add(0, 1);
        Iterator<Integer> myItr = myList.iterator();


        System.out.println("MyList: ");

        for (Iterator<Integer> iterator = myList.iterator(); iterator.hasNext(); ) {
            Integer integer = iterator.next();
            System.out.print(integer + " ");
        }
        System.out.println();

        myItr.next();
        myItr.remove();
        myItr.next();
        myItr.remove();
        myItr.next();
        myItr.remove();
        myItr.next();
        myItr.remove();

        System.out.println(myList.toString());
        System.out.println("ArrayList: ");


        for (Iterator<Integer> iterator = arrayList.iterator(); iterator.hasNext(); ) {
            Integer integer = iterator.next();
            System.out.print(integer + " ");
        }
        System.out.println();
        Iterator<Integer> arrayListItr = arrayList.iterator();

        arrayListItr.next();
        arrayListItr.remove();
        arrayListItr.next();
        arrayListItr.remove();
        arrayListItr.next();
        arrayListItr.remove();
        arrayListItr.next();
        arrayListItr.remove();

        System.out.println(arrayList.toString());

        System.out.println(arrayList.containsAll(myList));
        System.out.println(myList.containsAll(arrayList));
    }
}
