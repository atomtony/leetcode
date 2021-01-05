import java.util.Arrays;

public class Ch23_Tree {

    //==========二叉树 链式存储法========
    static class Node {
        Node left;
        Node right;
        String data;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static void linkStorageTest() {
        Node A = new Node();
        A.data = "A";

        Node B = new Node();
        B.data = "B";

        Node C = new Node();
        C.data = "C";

        Node D = new Node();
        D.data = "D";

        Node E = new Node();
        E.data = "E";

        Node F = new Node();
        F.data = "F";

        Node G = new Node();
        G.data = "G";

        A.left = B;
        A.right = C;

        B.left = D;
        B.right = E;

        C.left = F;
        C.right = G;

        System.out.println("前续遍历");
        preOrder(A);

        System.out.println("中续遍历");
        inOrder(A);

        System.out.println("后续遍历");
        postOrder(A);
    }
    //==========二叉树 链式存储法========


    //==========二叉树 链式存储法========
    static class TreeArray {
        private String[] array;
        private int count;

        public TreeArray(int count) {
            this.count = count;
            this.array = new String[count + 1];
        }

        public void insert(int i, String val) {
            this.array[i] = val;
        }

        public void preOrder(int index) {
            if (index > count || array[index] == null) {
                return;
            }
            System.out.println(array[index]);
            preOrder(index * 2);
            preOrder(index * 2 + 1);
        }

        public void inOrder(int index) {
            if (index > count || array[index] == null) {
                return;
            }
            inOrder(index * 2);
            System.out.println(array[index]);
            inOrder(index * 2 + 1);
        }

        public void postOrder(int index) {
            if (index > count || array[index] == null) {
                return;
            }
            postOrder(index * 2);
            postOrder(index * 2 + 1);
            System.out.println(array[index]);
        }
    }


    public static void seqStorageTest() {


        // 完全二叉树测试
        {
            TreeArray treeArray = new TreeArray(10);
            treeArray.insert(1, "A");
            treeArray.insert(2, "B");
            treeArray.insert(3, "C");
            treeArray.insert(4, "D");
            treeArray.insert(5, "E");
            treeArray.insert(6, "F");
            treeArray.insert(7, "G");
            treeArray.insert(8, "H");
            treeArray.insert(9, "I");
            treeArray.insert(10, "J");

            System.out.println("前续遍历");
            treeArray.preOrder(1);

            System.out.println("中续遍历");
            treeArray.inOrder(1);

            System.out.println("后续遍历");
            treeArray.postOrder(1);
        }

        // 不完全二叉树测试
        {
            TreeArray treeArray = new TreeArray(13);
            treeArray.insert(1, "A");
            treeArray.insert(2, "B");
            treeArray.insert(3, "C");
            treeArray.insert(4, "D");
            treeArray.insert(6, "E");
            treeArray.insert(8, "F");
            treeArray.insert(9, "G");
            treeArray.insert(13, "H");

            System.out.println("前续遍历");
            treeArray.preOrder(1);

            System.out.println("中续遍历");
            treeArray.inOrder(1);

            System.out.println("后续遍历");
            treeArray.postOrder(1);
        }

    }
    //==========二叉树 链式存储法========


    public static void main(String[] args) {
//        linkStorageTest();
        seqStorageTest();
    }


}
