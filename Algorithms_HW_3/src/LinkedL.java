public class LinkedL {
    Node head;
    Node tail;

    public void revert(){
        Node next;
        Node previous;
        Node node = tail;
        while(node != null){
            next = node.previous;
            previous = node.next;
            node.next = next;
            node.previous = previous;
            if(previous == null){
                head = node;
            }
            if (next == null){
                tail = node;
            }
            node = next;
        }
    }

    public void addTail(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void print(){
        Node node = head;
        while (node != null){
            System.out.println(node.value);
            node = node.next;
        }
    }

    class Node {
        int value;
        Node next;
        Node previous;
    }

}
