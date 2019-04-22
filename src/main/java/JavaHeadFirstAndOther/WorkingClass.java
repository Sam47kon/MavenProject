
package JavaHeadFirstAndOther;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        List<Integer> list = new LinkedList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);


        LinkedList<Integer> myList = new LinkedList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

        myList.addAll(list);
        System.out.println(myList.toString());
        System.out.println(myList.getFirst());
        System.out.println(myList.getLast());
        System.out.println(myList.get(5));
        System.out.println(myList.isEmpty());
        System.out.println(myList.contains(4));
        System.out.println(Arrays.toString(myList.toArray()));
    }
}
