package problems.archive.solutions;

import java.util.Arrays;

public class ZigZagConversionSolution {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int nRows) {
        System.out.println("String: " + s);
        System.out.println("rows: " + nRows);
        char[] c = s.toCharArray();
        System.out.println("c: " + Arrays.toString(c));
        int len = c.length;
        System.out.println("length: " + len);

        StringBuffer[] sb = new StringBuffer[nRows];//y
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();//x e.g. sb[0], sb[1], sb[2], sb[3]

        int i = 0;
        while (i < len) {//while for all characters, fors for valid chars
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
                System.out.println("vertical: " + Arrays.toString(sb));
            for (int idx = nRows-2/*start from here*/; idx >= 1 && i < len/*exclude first and last rows*/; idx--/*diagonal up*/) // obliquely up
                sb[idx].append(c[i++]);
                System.out.println("horizontal: " + Arrays.toString(sb));
        }
        for (int idx = 1; idx < sb.length; idx++)//linearise
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}
