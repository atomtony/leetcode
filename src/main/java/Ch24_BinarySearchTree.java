public class Ch24_BinarySearchTree {

    static class BinarySearchTree {

        private Node tree;

        public void insert(int data) {
            if (tree == null) {
                tree = new Node(data);
                return;
            }

            Node p = tree;
            while (p != null) {
                if (data > p.data) {
                    if (p.right == null) {
                        p.right = new Node(data);
                        return;
                    }
                    p = p.right;
                } else {
                    if (p.left == null) {
                        p.left = new Node(data);
                        return;
                    }
                    p = p.left;
                }
            }
        }

        public Node find(int data) {
            Node p = tree;
            while (p != null) {
                if (data < p.data) {
                    p = p.left;
                } else if (data > p.data) {
                    p = p.right;
                } else {
                    return p;
                }
            }
            return null;
        }

        public void delete(int data) {
            Node p = tree;
            Node pp = null;
            while (p != null && p.data != data) {
                pp = p;
                if (data > p.data) {
                    p = p.right;
                } else {
                    p = p.left;
                }
            }
            if (p == null) {
                return;
            }

            if (p.left != null && p.right != null) {
                Node minP = p.right;
                Node minPP = p;
                while (minP.left != null) {
                    minPP = minP;
                    minP = minP.left;
                }
                p.data = minP.data;
                p = minP;
                pp = minPP;
            }


            Node child;//要删除节点p的子节点
            if (p.left != null) {
                child = p.left;//仅有左子节点
            } else if (p.right != null) {
                child = p.right;//仅有右子节点
            } else {
                child = null;//没有子节点
            }


            if (pp == null) {
                tree = child;
            } else if (pp.left == p) {
                pp.left = child;
            } else {
                pp.right = child;
            }

        }

        public void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }

        public void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }

    }

    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        // 插入测试
        {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(33);
            binarySearchTree.insert(17);
            binarySearchTree.insert(13);
            binarySearchTree.insert(18);
            binarySearchTree.insert(16);
            binarySearchTree.insert(25);
            binarySearchTree.insert(19);
            binarySearchTree.insert(27);
            binarySearchTree.insert(50);
            binarySearchTree.insert(34);
            binarySearchTree.insert(58);
            binarySearchTree.insert(51);
            binarySearchTree.insert(66);
            binarySearchTree.insert(55);
            binarySearchTree.preOrder(binarySearchTree.tree);
        }

        // 查找测试
        {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(33);
            binarySearchTree.insert(17);
            binarySearchTree.insert(13);
            binarySearchTree.insert(18);
            binarySearchTree.insert(16);
            binarySearchTree.insert(25);
            binarySearchTree.insert(19);
            binarySearchTree.insert(27);
            binarySearchTree.insert(50);
            binarySearchTree.insert(34);
            binarySearchTree.insert(58);
            binarySearchTree.insert(51);
            binarySearchTree.insert(66);
            System.out.println("查找");
            System.out.println(binarySearchTree.find(19).data);
        }

        // 删除测试
        {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(33);
            binarySearchTree.insert(16);
            binarySearchTree.insert(13);
            binarySearchTree.insert(15);
            binarySearchTree.insert(18);
            binarySearchTree.insert(17);
            binarySearchTree.insert(25);
            binarySearchTree.insert(19);
            binarySearchTree.insert(27);
            binarySearchTree.insert(50);
            binarySearchTree.insert(34);
            binarySearchTree.insert(58);
            binarySearchTree.insert(51);
            binarySearchTree.insert(55);
            binarySearchTree.insert(66);

            System.out.println("删除 13");
            binarySearchTree.delete(13);
            binarySearchTree.preOrder(binarySearchTree.tree);


            System.out.println("删除 18");
            binarySearchTree.delete(18);
            binarySearchTree.preOrder(binarySearchTree.tree);


            System.out.println("删除 55");
            binarySearchTree.delete(55);
            binarySearchTree.preOrder(binarySearchTree.tree);
        }


    }
}
