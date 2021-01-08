public class Ch48 {

    static class BPlusTreeNode {
        static int m = 5;
        int[] keywords = new int[m - 1];
        public BPlusTreeNode[] children = new BPlusTreeNode[m];

    }

    static class BPlusTreeLeafNode {
        static int k = 3;
        public int[] keywords = new int[k];
        long[] dataAddress = new long[k];

        BPlusTreeLeafNode prev;
        BPlusTreeLeafNode next;
    }

    static class BPlusTree{

    }

    public static void main(String[] args) {




    }
}
