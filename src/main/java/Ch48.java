public class Ch48 {

    /**
     * https://github.com/ChenWenKaiVN/TreeSWT/blob/master/src/com/tree/bt/BTree.java
     */
    static class BPlusTreeNode {
        static int m = 5;
        int[] keywords = new int[m - 1];
        public BPlusTreeNode[] children = new BPlusTreeNode[m];

    }

    static class BPlusTreeLeafNode {
        static int k = 3;
        public int[] keywords = new int[k];
        Object[] dataAddress = new Object[k];

        BPlusTreeLeafNode prev;
        BPlusTreeLeafNode next;
    }

    static class BPlusTree {

        public void put(int key, Object value) {

        }


    }

    public static void main(String[] args) {

        BPlusTreeNode root = new BPlusTreeNode();


    }
}
