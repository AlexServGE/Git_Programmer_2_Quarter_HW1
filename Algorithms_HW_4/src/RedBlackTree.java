public class RedBlackTree {

    private Node root;

    private boolean addNode(Node node, int value) { //возвращает true, если создать новую Ноду возможно
        if (node.value == value) { //если в структуре уже есть предлагаемое значение, значит создать новую Ноду невозможно
            return false; //в бинарном дереве могут располагаться только уникальные значения - повторяющихся значений быть не может
        } else {
            if (node.value > value) { //если значение текущей Ноды (передана в параметрах) больше, чем искомого значения
                if (node.leftChild != null) { //и если левый ребенок существует
                    boolean result = addNode(node.leftChild, value); //запускается поиск по левому ребенку
                    node.leftChild = rebalance(node.leftChild); //возвращаясь из рекурсивного вызова, мы проверяем нужно ли нам делать ребалансировку
                    return result;
                } else {
                    node.leftChild = new Node(); //если левого ребенка не существует, значит мы нашли корректное место для постановки значения
                    node.leftChild.color = Color.RED; //создаем ноду, присваиваем ей красный цвет
                    node.leftChild.value = value; //у красно-черного дерева все вновь создаваемые ноды получают красный цвет
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    public boolean add (int value){
        if (root != null) {
            boolean result = addNode(root,value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED && //у ноды есть правый ребенок, у которого красный цвет
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)) { //у ноды есть левый ребенок, у которого черный цвет
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.rightChild != null && result.rightChild.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }

        } while (needRebalance);
        return result;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private void colorSwap(Node node) { // только в тех случаях, когда у ноды два красных ребенка
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }


    private class Node {
        private int value;
        private Color color;
        private Node leftChild;
        private Node rightChild;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", color=" + color +
                    '}';
        }
    }

    private enum Color {
        RED, BLACK
    }
}
