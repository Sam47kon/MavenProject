package JavaHeadFirstAndOther.Sets;


import java.util.HashSet;

public class InfoSets {    // множества HeadSet,LinkedHashSet, TreeSet.
//    синтаксис HashSet<String> myHashSet = new HashSet<String>();

//    HashSet хранит элементы в произвольном порядке,
//    но зато быстро ищет. Подходит, если порядок Вам не важен, но важна скорость.
//    Более того, для оптимизации поиска, HashSet будет хранить элементы так, как ему удобно.

//    LinkedHashSet будет хранить элементы в порядке добавления, но зато работает медленнее.

//    TreeSet хранит элементы отсортированными.


//    1. add() - добавляет элемент в множество
//
//    2. remove() - удаляет элемент из множества
//
//    3. contains() - определяет, есть ли элемент в множестве
//
//    4. size() - возвращает размер множества
//
//    5. clear() - удаляет все элементы из коллекции
//
//    6. isEmpty() - возвращает true если множество пустое, и false если там есть хотя бы 1 элемент


    public static void main(String[] args) {
        HashSet<Integer> integerHashSet = new HashSet<>();

        integerHashSet.add(9541);
        integerHashSet.add(645);
        integerHashSet.add(9541);  // ошибки не будет но существующий уже объект не будет записан в множество
        integerHashSet.add(64);
        integerHashSet.add(-999);

        System.out.println("Элементы integerHashSet: ");
        for (Integer i : integerHashSet) {
            System.out.print(i + ", ");
        }
        System.out.println(("\nРазмер integerHashSet = " + integerHashSet.size()));
        System.out.println(("Есть ли в integerHashSet элемент 9541? " + (integerHashSet.contains(9541) ? "yes" : "no")));

        integerHashSet.remove(9541);
        System.out.println(("Элементы integerHashSet после удаления: " + integerHashSet));
        System.out.println(("Размер integerHashSet после удаления = " + integerHashSet.size()));
        System.out.println(("А теперь есть ли в integerHashSet элемент 9541? " + (integerHashSet.contains(9541) ? "yes" : "no")));

    }


}