public class Ch06_SinglyLinkedList {

    static class Node {
        int data;
        Node next;
    }

    static class SinglyLinkedList {

        Node head;

        public void add(int value) {
            if (head == null) {
                head = new Node();
                head.data = value;
            } else {
                Node parent = head;
                while (parent.next != null) {
                    parent = parent.next;
                }
                Node newNode = new Node();
                newNode.data = value;
                parent.next = newNode;
            }
        }

        public void add(int index, int value) {
            // 链表为空
            if (head == null) {
                return;
            }

            // 头节点位置
            if (index == 0) {
                Node newNode = new Node();
                newNode.data = value;

                newNode.next = head;
                head = newNode;
                return;
            }

            Node parent = head;
            Node current = head;
            int position = 0;

            while (current != null) {
                parent = current;
                current = current.next;
                position++;

                if (position == index) {
                    break;
                }
            }

            // 找到节点
            if (position == index) {
                Node newNode = new Node();
                newNode.data = value;

                parent.next = newNode;
                newNode.next = current;

            }

        }

        public void remove(int value) {

            // 链表为空
            if (head == null) {
                return;
            }

            Node parent = head;
            Node current = head;

            while (current != null && current.data != value) {
                parent = current;
                current = current.next;
            }

            // value 不存在
            if (current == null) {
                return;
            }

            // 删除头节点
            if (current == head) {
                head = head.next;
                return;
            }

            //  删除current节点
            parent.next = current.next;

        }

        public void printAll() {
            Node p = head;
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

        System.out.println("指定位置添加");
        singlyLinkedList.add(0, 1);
        singlyLinkedList.printAll();

        singlyLinkedList.add(2, 3);
        singlyLinkedList.printAll();

    }


}
