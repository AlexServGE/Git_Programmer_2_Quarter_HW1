public class Main {
    public static void main(String[] args) {
        LinkedL testLinked = new LinkedL();
        testLinked.addTail(1);
        testLinked.addTail(2);
        testLinked.addHead(3);
        LinkedL.Node node = testLinked.head;
        while (node != null){
            System.out.println(node.value);
            node = node.next;
        }
    }
}