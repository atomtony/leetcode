public class Ch06_DoublyLinkedList {

    static class Node {
        int data;
        Node prev;
        Node next;
    }

    static class DoublyLinkedList {

        Node head;

        public void add(int value) {

            // 创建节点
            Node newNode = new Node();
            newNode.data = value;

            if (head == null) {
                head = newNode;
            } else {
                Node tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = newNode;

                newNode.prev = tail;
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

            if (0 != index) {
                while (current != null) {
                    parent = current;
                    current = current.next;
                    position++;

                    if (position == index) {
                        break;
                    }
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

            Node current = head;
            while (current != null && current.data != value) {
                current = current.next;
            }

            // value 不存在
            if (current == null) {
                return;
            }

            // 删除头节点
            if (current == head) {
                head = head.next;
                head.prev = null;
                return;
            }

            //  删除尾节点
            if (current.next == null) {
                Node prev = current.prev;

                prev.next = null;
                current.prev = null;
                return;
            }

            // 删除中间节点
            current.prev.next = current.next;
            current.next.prev = current.prev;

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
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        System.out.println("双向链表添加测试");
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);
        doublyLinkedList.add(5);
        doublyLinkedList.printAll();

        System.out.println("删除不存在节点");
        doublyLinkedList.remove(0);
        doublyLinkedList.printAll();

        System.out.println("删除头节点");
        doublyLinkedList.remove(1);
        doublyLinkedList.printAll();

        System.out.println("删除尾节点");
        doublyLinkedList.remove(5);
        doublyLinkedList.printAll();

        System.out.println("删除中间节点");
        doublyLinkedList.remove(3);
        doublyLinkedList.printAll();

    }

}
