import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class RemoveRepeatArray {
//    public int removeDuplicates(int[] nums){
//       HashSet<Integer> set =new HashSet();
//        for (int i : nums
//             ) {
//            set.add(i);
//        }
//       return set.size();
//    }
    public int removeDuplicates(int[] nums){
        if(nums.length==0){
            return 0;
        }
      int length=0;
      Arrays.sort(nums);
      int i=0;
       for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
             nums[i+1]=nums[j];
             i++;
            }
            }

        return i+1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] strs=sc.nextLine().split(",");
        int[] nums= new int[strs.length];
        for(int i=0;i<strs.length;i++){
            nums[i]=Integer.parseInt(strs[i]);
        }
        RemoveRepeatArray removeRepeatArray= new RemoveRepeatArray();
       int i= removeRepeatArray.removeDuplicates(nums);
       System.out.println(removeRepeatArray.removeDuplicates(nums));
    }

}
