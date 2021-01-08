import java.util.LinkedList;

public class Ch06_SinglyLinkedList {

    static class Node {
        int data;
        Node next;
    }

    static class SinglyLinkedList {

        Node root;

        public void add(int value) {
            if (root == null) {
                root = new Node();
                root.data = value;
            } else {
                Node parent = root;
                while (parent.next != null) {
                    parent = parent.next;
                }
                Node newNode = new Node();
                newNode.data = value;
                parent.next = newNode;
            }
        }

        public void remove(int value) {

            // 链表为空
            if (root == null) {
                return;
            }

            Node parent = root;
            Node current = root;

            while (current != null && current.data != value) {
                parent = current;
                current = current.next;
            }

            // value 不存在
            if (current == null) {
                return;
            }

            // 删除头节点
            if (current == root) {
                root = root.next;
                return;
            }

            //  删除current节点
            parent.next = current.next;

        }

        public void printAll() {
            Node p = root;
            while (p != null) {
                System.out.print("->" + p.data);
                p = p.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        System.out.println("单链表添加测试");
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        singlyLinkedList.add(5);
        singlyLinkedList.printAll();

        System.out.println("删除不存在节点");
        singlyLinkedList.remove(0);
        singlyLinkedList.printAll();


        System.out.println("删除头节点");
        singlyLinkedList.remove(1);
        singlyLinkedList.printAll();

        System.out.println("删除尾节点");
        singlyLinkedList.remove(5);
        singlyLinkedList.printAll();

        System.out.println("删除中间节点");
        singlyLinkedList.remove(3);
        singlyLinkedList.printAll();

    }


}