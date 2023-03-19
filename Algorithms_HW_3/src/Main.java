public class Main {
    public static void main(String[] args) {
        LinkedL testLinked = new LinkedL();
        testLinked.addTail(1);
        testLinked.addTail(2);
        testLinked.addTail(3);
        testLinked.addTail(4);
        testLinked.addTail(5);
        testLinked.print();
        System.out.println(">>>>>>>>>>>>>>>");
        testLinked.revert();
        testLinked.print();
    }
}