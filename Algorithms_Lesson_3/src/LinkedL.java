public class LinkedL {

    Node head;
    Node tail;


    /**
     * Стэк
     */

    public void pushSt(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public Integer popSt(){
        Integer result = null;
        if (head != null){
            result = head.value;
            head = head.next;
        }
        return result;
    }


    /**
     * Очередь
     */

    public void pushQ(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    public Integer peekQ(){
        Integer result = null;
        if (tail != null){
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }

    /**
     * Односвязные список
     */
    public void revertOneLinked(){
        if (head != null && head.next != null){
            Node temp = head;
            revertOneLinked(head.next,head);
            temp.next = null;
        }
    }
    private void revertOneLinked(Node currentNode, Node previousNode){
        if (currentNode.next == null){      //доходим до конца односвязного списка и обозначаем head
            head = currentNode;
        } else {
            revertOneLinked(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;    //далее с конца односвязного списка назначаем новые next
    }


    /**
     * Двусвязный список
     */
    public void addTail(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {                    // head.prev -> null,   head -> 1,  head.next -> 2,3 <-tail.prev,   4 <-tail,   null <-tail.next
            tail.next = node;       // head.prev -> null,   head -> 1,  head.next -> 2,3 <-tail.prev,   4 <-tail,   6 <-tail.next
            node.previous = tail;   // head.prev -> null,   head -> 1,  head.next -> 2,3 <-tail.prev,   4 <-tail,   tail<-6 <-tail.next
            tail = node;            // head.prev -> null,   head -> 1,  head.next -> 2,3,4 <-tail.prev, 6 <-tail,   null <-tail.next
        }
    }

    public void addHead(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.previous = node;
            node.next = head;
            head = node;
        }
    }




    public void addMiddle(int value, Node node) {
        Node newNode = new Node();      //Создаем новую Node
        newNode.value = value;          //Присваиваем значение новой Node
        newNode.previous = node;        //Присваиваем ссылку на prev новой Node
        if (node.next == null) {
            tail = newNode;             //Если после найденной Node стоит null, то перемещаем tail
        } else {                        //Если после найденной Node есть элементы
            newNode.next = node.next;   //Присваиваем ссылку на next новой Node
            node.next.previous = newNode; //Переприсваиваем ссылку prev следующего Node
            node.next = newNode;        //Переприсваиваем ссылку next найденного элемента
        }
    }

    public void delete(Node node) {
        Node previous = node.previous;  //Можно и без сохранения в отдельные переменные,
        Node next = node.next;          //Однако так будет меньше лапше-кода
        if (previous == null) {         //Если это крайний элемент с начала списка,
            next.previous = null;       //то удаляем на него ссылку из соседнего (тк двусторонний список)
            head = node.next;           //присваиваем head ссылку на соседний элемент
        } else if (next == null) {
            previous.next = null;
            tail = node.previous;
        } else {
            previous.next = next;
            next.previous = previous;
        }
    }

    public void revert(){
        Node currentNode = head;
        while (currentNode != null){
            Node next = currentNode.next;           //сохраняем в отдельные переменные значения, которые будем менять
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous=next;
            if (previous == null){
                tail = currentNode;
            }
            if (next == null){
                head = currentNode;
            }
            currentNode = next;
        }
    }


    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public class Node {

        int value;
        Node next;
        Node previous;
    }


}
