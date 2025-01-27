package problems.archive.solutions;

public class ReverseWordsSolution {
    public static void main(String[] args) {
//        System.out.print(reverseWords("helloWorld"));
        System.out.print(reverseWords("test spaces  here   now"));
    }

    public static String reverseWords(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    static void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces (be the start of individual word)
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces (get to end of individual word)
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    static String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces (leading)
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces (copies non-space)
            while (j < n && a[j] == ' ') j++;             // skip spaces (trailing)
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private static void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];//temp
            a[i++] = a[j];//first flip
            a[j--] = t;//last flip
        }
    }
}
