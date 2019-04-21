package GolovachDecember2013.CoreProcedural4;

import static java.util.Arrays.copyOfRange;

public class Node {
    private int value;
    private Node next;

    private Node() {
    }

    private Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    private static Node genIter(int... values) {     // генерировать итеративно
        Node head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            head = new Node(values[i], head);
        }
        return head;
    }

    private static Node genRec(int... values) {     // генерировать рукурсивно
        return values.length == 0 ? null : new Node(values[0], genRec(copyOfRange(values, 1, values.length)));
    }

    private static String toStringIter(Node head) {
        StringBuilder result = new StringBuilder();
        while (head != null) {
            result.append(head.value).append("->");
            head = head.next;
        }
        return result.append("*").toString();
    }

    private static String toStringRec(Node head) {
        return head == null ? "*" : head.value + "->" + toStringRec(head.next);
    }

    private static Node merge(Node head1, Node head2) {
        if (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                return new Node(head1.value, merge(head1.next, head2));
            } else {
                return new Node(head2.value, merge(head1, head2.next));
            }
        } else {
            return (head1 == null) ? head2 : head1;
        }
    }

    private static Node copy(Node head) {
        return head == null ? null : new Node(head.value, copy(head.next));
    }


    private static boolean isEqual(Node head1, Node head2) {     // метод сравнения двух списков

        if (head1 != null && head2 != null) {
            return head1.value == head2.value && isEqual(head1.next, head2.next);
        } else return head1 == head2;
    }

    private static int length(Node head) {
        return head == null ? 0 : 1 + length(head.next);
    }

    private static int max(Node head) {
        return head == null ? 0 : Math.max(head.value, max(head.next));
    }

    private static int sum(Node head) {
        return head == null ? 0 : head.value + sum(head.next);
    }

    private static boolean isGrowing(Node head) { // неверно
        return head != null && (head.value < head.next.value && isGrowing(head.next));
    }

    private static int isGrowing1(Node head) {
        return head == null ? 1 : head.next.value - head.value > 0 ? isGrowing1(head.next) : 0;
    }

    private static Node addLast(Node head, int value) {    // помстить значение value в конец Node
        head = new Node(value, head);   // TODO помещает в начало, не пойму как в конец
        return head;
    }

    private static Node add(Node head, int value) { // неверно
        return head == null ? new Node(value, null) : add(head.next, head.value);
    }

    public static void main(String[] args) {
//        Node tail;    // хвост

//        Node head0;    // голова
//        Node node0 = new Node(0, null);
//        Node node1 = new Node(1, null);
//        Node node2 = new Node(2, null);
//        Node node3 = new Node(3, null);
//        node3.next = node2;
//        node2.next = node1;
//        node1.next = node0;
//        head0 = node3;

//        Node head00;
//        head00 = new Node(0, null);
//        head00 = new Node(1, head00);
//        head00 = new Node(2, head00);
//        head00 = new Node(3, head00);

        Node head1 = genIter(1, 2, 3, 4, 5, 5, 6);
        System.out.println("head1: " + toStringIter(head1) + ", length: " + length(head1));
        head1 = add(head1, 7);
        System.out.println(toStringIter(head1));

        Node head2 = genRec(4, 5, 6, 7, 8, 9);
        System.out.println("head2: " + toStringRec(head2) + ", length: " + length(head2));

        System.out.println("head1==head2? " + isEqual(head1, head2));
        System.out.println("----------------");


        Node head1_2 = merge(head1, head2);
        System.out.println("head1_2: " + toStringRec(head1_2) + ", length: " + length(head1_2));
        Node copyHead1_2 = copy(head1_2);
        System.out.println(toStringRec(copyHead1_2));
        System.out.println("head1_2==copyHead1_2? " + isEqual(head1_2, copyHead1_2));

//        Node head3 = genIter(5, 5, 9, 7);
//        System.out.println("isGrow head1 - " + isGrowing1(head1));
//        System.out.println("isGrow head3 - " + isGrowing1(head3));

    }
}
