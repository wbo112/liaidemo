import java.util.Arrays;
import java.util.HashMap;

public class StrStr {
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
      String haystack="qweers";
      String needle="ee";
      StrStr str= new StrStr();
        System.out.println(str.strStr(haystack,needle));
    }
} 

