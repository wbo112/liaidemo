import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int max = 0;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int row = Integer.parseInt(line.trim().split("\\s+")[0]);
        int col = Integer.parseInt(line.trim().split("\\s+")[1]);
        int[][] arrs = new int[row][col];
        for (int i = 0; i < row; i++) {
            arrs[i] = Arrays.stream(scanner.nextLine().trim().split("\\s+")).mapToInt(x -> Integer.parseInt(x)).toArray();
        }
        calc(arrs);
        System.out.println(max);
    }

    private static void calc(int[][] arrs) {
        int[][] temp = new int[arrs.length][arrs[0].length];
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                if (temp[i][j] == 0 && arrs[i][j] == 1) {
                    count = 0;
                    findPath(temp, arrs, i, j);

                    if (max < count) {
                        max = count;

                    }
                }
            }
        }

    }

    private static void findPath(int[][] temp, int[][] arrs, int x, int y) {
        if (x < 0 || x > arrs.length - 1 || y < 0 || y > arrs[0].length - 1) {
            return;
        }
        if (temp[x][y] == 1 || arrs[x][y] == 0) {
            return;
        }
        if (arrs[x][y] == 1) {
            temp[x][y] = 1;
            count++;
        }
        findPath(temp, arrs, x - 1, y);
        findPath(temp, arrs, x + 1, y);
        findPath(temp, arrs, x, y - 1);
        findPath(temp, arrs, x, y + 1);

    }

}
