
import java.nio.charset.Charset;
import java.util.*;

public class Ch37 {

    static class Char implements Comparable<Char> {
        String ch;//字符
        int rate;//出现的频率
        int count;//写个数
        String bits = "";
        int hufBitsCount;

        public Char(String ch, int rate, int hufBitsCount) {
            this.ch = ch;
            this.rate = rate;
            this.hufBitsCount = hufBitsCount;
        }

        @Override
        public int compareTo(Char aChar) {
            return rate - aChar.rate;
        }

    }

    static class Node {
        Node left;
        Node right;
        Char aChar;
    }

    public static void bits(Node node, String bits) {

        if (node.right != null) {
            node.right.aChar.bits = node.right.aChar.bits + bits + "1";
//            System.out.println(node.right.aChar.ch + "\t" + node.right.aChar.bits);
        }

        if (node.left == null) {
            node.aChar.bits = node.aChar.bits + bits;
//            System.out.println(node.aChar.ch + "\t" + node.aChar.bits);
        }

        if (node.left != null) {
            bits(node.left, bits + "0");
        }
    }

    public static void main(String[] args) {

        List<Char> list = new ArrayList<>(Arrays.asList(
                new Char("a", 450, 450),
                new Char("b", 350, 700),
                new Char("c", 90, 270),
                new Char("d", 60, 240),
                new Char("e", 30, 150),
                new Char("f", 20, 100)
        )
        );
        List<Char> bak = new ArrayList<>();

        int totalSize = 0;
        int totalHufBitsCount = 0;
        for (Char aChar : list) {
            totalSize += aChar.rate;
            totalHufBitsCount += aChar.hufBitsCount;
        }

        System.out.println("总字符数：" + totalSize);

        // ======以下是生成文档======
        StringBuilder documentBuilder = new StringBuilder();
        Random random = new Random();
        int size = list.size();
        while (size != 0) {
            int index = random.nextInt(size);
            Char aChar = list.get(index);
            documentBuilder.append(aChar.ch);
            aChar.count++;
            if (aChar.rate == aChar.count) {
                list.remove(aChar);
                bak.add(aChar);
                size--;
            }
        }
        System.out.println("生成的文档大小：" + documentBuilder.toString().length());
        // ======以下是生成文档======

        list.addAll(bak);
        // 升序
        Collections.sort(list);

        // 构建二叉树
        Node root = new Node();
        root.aChar = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            // 右节点
            Node node = new Node();
            node.aChar = list.get(i);

            // 新的顶点，合并左右字节点频数
            Node newNode = new Node();
            newNode.left = root;
            newNode.right = node;
            newNode.aChar = new Char("y", root.aChar.rate + node.aChar.rate, 0);

            root = newNode;
        }

        bits(root, "");

        //开始霍夫曼编码
        Map<String, String> map = new HashMap<>();
        for (Char ch : list) {
            map.put(ch.ch, ch.bits);
        }

        StringBuilder bitStr = new StringBuilder();
        String document = documentBuilder.toString();

        for (int i = 0; i < document.length(); i++) {
            String ch = String.valueOf(document.charAt(i));
            bitStr.append(map.get(ch));
        }

        System.out.println("totalHufBitsCount:"+totalHufBitsCount);
        System.out.println("霍夫曼编码编码后的二进制位数：" + bitStr.toString().length());

        //剩下的就是二进制转16进制，写入文件


    }

}
