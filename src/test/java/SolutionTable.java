import java.util.Scanner;

public class SolutionTable {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        else {
            int[] table = new int[26];
            for (int i = 0; i < s.length(); i++) {
                table[s.charAt(i)-'a']++;
            }
            for ( int i = 0 ;i < t.length(); i++) {
                table[t.charAt(i)-'a']--;
                if (table[t.charAt(i)-'a']< 0) {
             return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String  s1 = s.next();
        String t1 = s.next();
        s.close();
        SolutionTable solution =new SolutionTable();
        solution.isAnagram(s1,t1);
        System.out.println(solution.isAnagram(s1,t1));

    }

}
