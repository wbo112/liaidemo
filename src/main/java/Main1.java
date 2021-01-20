import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {
    private static final String ABSENT = "absent";
    private static final String LATE = "late";
    private static final String EAVEEARLY = "eaveearly";
    private static final String PRESENT = "present";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine().trim());
        String line;
        String[] arr;
        for (int i = 0; i < row; i++) {
            line = scanner.nextLine();
            arr = line.trim().split("\\s+");
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(calc(arr));


        }

    }

    private static boolean calc(String[] arr) {
        int a = 0;//缺勤
        int b = 0;//连续迟到、早退
        LinkedList<Integer> linkedList = new LinkedList<>();//连续7天情况
        for (String str : arr) {

            if (linkedList.size() >= 7) {
                linkedList.removeFirst();
            }
            if (PRESENT.equals(str)) {
                linkedList.add(0);
            } else {
                linkedList.add(1);
            }
            if (linkedList.stream().mapToInt(Integer::intValue).sum() > 3) {
                return false;
            }
            if (ABSENT.equals(str)) {
                a++;
            }
            if (LATE.equals(str) || EAVEEARLY.equals(str)) {
                b++;
            } else  {
                b = 0;
            }
            if (a > 1 || b > 1) {
                return false;
            }
        }
        return true;
    }
}
