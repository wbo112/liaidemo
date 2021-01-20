import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class yiwei {
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        if (s1.length != t1.length) {
            return false;
        } else {
            for (int i = 0; i < s1.length; i++) {
                if (s1[i] != t1[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
//        yiwei yw = new yiwei();
//        String s = "rat";
//        String t = "car";
//        System.out.println(yw.isAnagram(s, t));
        int[][] s1 = {{1, 2, 3,12}, {4, 5, 6,13}, {7, 8, 9,14},{17, 18, 19,24}};
        System.out.println(spiralOrder(s1));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        boolean[][] fmatrix = new boolean[matrix.length][matrix[0].length];

        int v = 0;
        int i = 0;
        int j = 0;
        int count = matrix.length * matrix[0].length;
        int n;
        while (list.size() != count) {
            if (v % 4 == 0) {
                if (!fmatrix[i][j]) {
                    list.add(matrix[i][j]);
                    fmatrix[i][j] = true;
                    n = j + 1;
                    if (n == matrix[i].length || fmatrix[i][n]) {
                        v++;
                        i++;
                    } else {
                        j++;
                    }
                } else {
                    v++;
                    i++;
                }


            } else if (v % 4 == 1) {
                if (!fmatrix[i][j]) {
                    list.add(matrix[i][j]);
                    fmatrix[i][j] = true;
                    n = i + 1;
                    if (n == matrix.length || fmatrix[n][j]) {
                        v++;
                        j--;
                    } else {
                        i++;
                    }
                } else {
                    v++;
                    j--;
                }

            } else if (v % 4 == 2) {
                if (!fmatrix[i][j]) {
                    list.add(matrix[i][j]);
                    fmatrix[i][j] = true;
                    n = j - 1;
                    if (n < 0 || fmatrix[i][n]) {
                        v++;
                        i--;
                    } else {
                        j--;
                    }
                } else {
                    v++;
                    i--;
                }
            } else if (v % 4 == 3) {
                if (!fmatrix[i][j]) {
                    list.add(matrix[i][j]);
                    fmatrix[i][j] = true;
                    n = i - 1;
                    if (n < 0 || fmatrix[n][j]) {
                        v++;
                        j++;
                    } else {
                        i--;
                    }
                }
            } else {
                v++;
                j++;
            }
        }
        return list;
    }

}
