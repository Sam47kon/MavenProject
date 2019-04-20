package GolovachDecember2013.CoreProcedural4;

public class Node {
    private int value;
    private Node next;

    private Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public static void main(String[] args) {
        Node tail;    // хвост
        Node node0 = new Node(0, null);
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        node3.next = node2;
        node2.next = node1;
        node1.next = node0;
        tail = node3;

        Node tail1;
        tail1 = new Node(0, null);
        tail1 = new Node(1, tail1);
        tail1 = new Node(2, tail1);
        tail1 = new Node(3, tail1);


    }
}
