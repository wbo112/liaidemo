import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlusTwoNumTable {
    private int[] twoSum( int[] nums, int target) {
        Map<Integer,Integer> hashtable = new HashMap<>();
        for(int i = 0; i <nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {

                return new int[]{hashtable.get(target - nums[i]),i};
            }
            hashtable.put(nums[i],i);
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
        PlusTwoNumTable sum = new PlusTwoNumTable();
        int[] s1 = sum.twoSum(nums, target);

        System.out.println(Arrays.toString(s1));
    }

    }

