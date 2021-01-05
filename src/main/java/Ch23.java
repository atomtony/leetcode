public class Ch23 {

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

    public static void postOrder(Node root){
        if (root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }


    public static void main(String[] args) {

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
}
