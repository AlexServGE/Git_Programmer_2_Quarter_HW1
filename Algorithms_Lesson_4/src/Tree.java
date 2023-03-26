import java.util.ArrayList;
import java.util.List;

public class Tree {
    Node root; //базовое поле. Начало, с которого мы можем начать любой обход/обращение к дереву


/**
 * Поиск вглубь в несбалансированном бинарном дереве
 */
//    public boolean exist (int value){
//        if (this.root == null){
//            return false;
//        }
//        Node node = find(this.root,value);
//        if (node != null){
//            return true;
//        }
//        return false;
//    }
//    private Node find(Node node, int value) {
//        if (node.value == value) {
//            return node;
//        } else {
//            for (Node child : node.children) {
//                Node result = find(child, value);
//                if (result != null) {   //кусок кода требуется для случая,
//                    return result;      //когда мы нашли искомое значение и хотим завершить все вызовы рекурсии
//                }
//            }
//        }
//        return null;
//    }

    /**
     * Горизонтальный поиск элемента в несбалансированном бинарном дереве
     * @param value
     * @return
     */
    private Node find(int value) {
        List<Node> currentLine = new ArrayList<>();
        currentLine.add(root);  //самая первая линия - линия root элемента
        while (currentLine.size() > 0) {
            List<Node> nextLine = new ArrayList<>(); //создаем объект для добавления детей родителей
            for (Node node : currentLine) {
                if (node.value == value) {
                    return node; //если нашли элемент, заканчиваем работу функции
                }
                nextLine.addAll(node.children);//если родитель не является искомым элементом,
            }                                   //то сразу добавляем его детей в пул для прохода следующей линии
            currentLine = nextLine;
        }
        return null;
    }

    public class Node {
        int value;
        List<Node> children; //список детей. древо чаще всего не реализуется для обхода вверх - только вниз
    }

}
