package day2.stack;

public class Browser {

    static class Node<T> {
        private T value;
        private Node next;
    }

    static class Stack<T> {

        private Node<T> head;
        private int size = 0;

        public boolean push(T item) {
            if (head == null) {
                head = new Node<>();
                head.value = item;
            } else {
                Node tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }

                Node<T> newNode = new Node<>();
                newNode.value = item;
                tail.next = newNode;
            }
            size++;
            return true;
        }

        public T pop() {
            Node<T> tail = head;
            // 无数据
            if (tail == null) {
                return null;
            }

            // 只有一个元素
            if (tail.next == null) {
                head = null;
                size--;
                return tail.value;
            }

            //
            Node<T> parent = head;
            while (tail.next != null) {
                parent = tail;
                tail = tail.next;
            }

            parent.next = null;
            size--;
            return tail.value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void clear() {
            this.head = null;
            this.size = 0;
        }
    }

    private String current;
    Stack<String> backStack;
    Stack<String> forwardStack;

    public Browser() {
        backStack = new Stack<String>();
        forwardStack = new Stack<String>();
    }

    public void open(String url) {
        if (current != null) {
            this.backStack.push(this.current);
            this.forwardStack.clear();
        }
        showUrl(url, "Open");
    }

    public void showUrl(String url, String prefix) {
        this.current = url;
        System.out.println(prefix + " page == " + url);
    }

    public String goBack() {
        String url = null;
        if (!backStack.isEmpty()) {
            url = backStack.pop();
            forwardStack.push(url);
            showUrl(url,"Back");
        }
        return url;
    }

    public String goForward() {
        String url = null;
        if (!forwardStack.isEmpty()) {
            url = forwardStack.pop();
            backStack.push(url);
            showUrl(url, "Foward");
        }
        return url;
    }

    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();

    }


}
