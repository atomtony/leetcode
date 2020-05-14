
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

public class UnicodeTest {

    public static String unicodeToCh(byte[] bytes) {
        String hex = HexBin.encode(bytes);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < hex.length() / 4; i++) {
            char ch = (char) Integer.valueOf(hex.substring(i * 4, i * 4 + 4), 16).intValue();
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        byte[] byteArray = new byte[]{0x46, 0x4E, 0x26, 0x26, 0x41, 0x26, 0x26, 0x5F, 0x20, 0x4E, 0x09, 0x26, 0x26, 0x31, 0x30, 0x30, 0x38, 0x36, 0x26, 0x26, 0x67, 0x4E, 0x56, (byte) 0xDB, 0x26, 0x26, 0x31, 0x33, 0x36, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x26, 0x26, 0x00, 0x41, 0x00, 0x42, 0x00, 0x43, 0x26, 0x26, 0x38, 0x37, 0x36, 0x35, 0x34, 0x33, 0x32, 0x31, 0x26, 0x26, 0x26, 0x26, 0x23, 0x23};
        String hex = HexBin.encode(byteArray);
        String[] arr2 = hex.split("2626");
        for (int i = 0; i < arr2.length; i++) {
            if (i == 2 || i == 4 || i == 6) {
                System.out.println(unicodeToCh(HexBin.decode(arr2[i])));
            } else {
                System.out.println(new String(HexBin.decode(arr2[i])));
            }
        }
    }
}
