import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        } else {
            char[] str1 = new char[s.length()];
            char[] str2 = new char[t.length()];
            for (int i = 0 ;i < str1.length; i++) {
                str1[i] = s.charAt(i);
                str2[i] = t.charAt(i);
            }
            Arrays.sort(str1);
            Arrays.sort(str2);
            return Arrays.equals(str1,str2);
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
           String  s1 = s.next();
           String t1 = s.next();
           Solution solution =new Solution();
        System.out.println(solution.isAnagram(s1,t1));

    }
}
