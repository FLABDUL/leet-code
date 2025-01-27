package problems.archive.practise;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        //char and length
        char[] c = s.toCharArray();
        int len = c.length;

        //create stringbuffers across
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i = 0; i < sb.length; i++){
            sb[i] = new StringBuffer();
        }

        //createmap
        int i = 0;
        //vertical down
        while (i<len) {
            for (int idx = 0; idx < numRows/*all rows start from 0*/ && i < len/*protection edge case*/; idx++) {
                //add letters
                sb[idx].append(c[i++]);//could increment i outside aswell
            }
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                sb[idx].append(c[i++]);
            }
        }

        //linearise
        for(int idx = 1; idx<sb.length; idx++){
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();

    }
}
