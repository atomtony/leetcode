public class Ch45_BitMap {


    static class BitMap {
        private char[] bytes;// char 两个字节 16个bit
        private int nbits;

        public BitMap(int nbits) {
            this.nbits = nbits;
            this.bytes = new char[nbits / 16 + 1];
        }

        public void set(int k) {
            if (k > nbits) return;
            // 除以16是因为char在java中占用2个字节
            int byteIndex = k / 16;
            int bitIndex = k % 16;
            System.out.println((int)( 1 << bitIndex));
            bytes[byteIndex] |= (1 << bitIndex);
        }
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(12);

        bitMap.set(3);

        System.out.println("a");
    }

}
