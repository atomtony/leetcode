public class SeqUtils {

    public static String seqJoin(String... strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
        }
        return builder.toString();
    }

    public static String seqJoin2(String... strs) {
        return String.join("", strs);
    }


    public static String seqJoin3(String... strs) {
        int len = 0;
        for (String str : strs) {
            len += str.length();
        }
        StringBuilder builder = new StringBuilder(len);
        for (String str : strs) {
            builder.append(str);
        }
        return builder.toString();
    }

    public static String seqJoin4(String... strs) {
        int len = 0;
        for (String str : strs) {
            len += str.length();
        }
        char[] buffer = new char[len];
        int offset = 0;
        for (String str : strs) {
            char[] chars = str.toCharArray();
            System.arraycopy(chars, 0, buffer, offset, chars.length);
            offset += chars.length;
        }
        return new String(buffer);
    }

    public static <T> String seqJoin5(T... params) {
        StringBuilder builder = new StringBuilder();
        for (T param : params) {
            builder.append(param);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(seqJoin("aa", "阿斯顿发生", "cc"));
        System.out.println(seqJoin2("aa", "阿斯顿发生", "cc"));
        System.out.println(seqJoin3("aa", "阿斯顿发生", "cc"));
        System.out.println(seqJoin4("aa", "阿斯顿发生", "cc"));
        System.out.println(seqJoin5("aa", "阿斯顿发生", "cc"));
        System.out.println(seqJoin5(1, "阿斯顿发生", "aa"));
        {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                seqJoin("aa", "bb", "cc");
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }

        {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                seqJoin2("aa", "bb", "cc");
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }

        {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                seqJoin3("aa", "bb", "cc");
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }

        {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                seqJoin4("aa", "bb", "cc");
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }

        {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                seqJoin5("aa", "bb", "cc");
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }

        {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                seqJoin5(1, 2, 3);
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }
}
