import java.util.Arrays;
import java.util.Scanner;

public class PlusTwoNum {
    private int[] sumTwoNum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] < target) {

           for (int j = 1; j<nums.length; j++){
                 if (nums[i]+nums[j] == target) {
                   return new int[]{i,j};
                 }
                }
            }

       }
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[]   str = sc.nextLine().split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] =Integer.parseInt(str[i]);
        }
        int target = sc.nextInt();
        PlusTwoNum sum = new PlusTwoNum();
        int[] s1 = sum.sumTwoNum(nums, target);

        System.out.println(Arrays.toString(s1));
    }
}
