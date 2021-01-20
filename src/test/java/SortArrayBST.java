import java.util.ArrayList;
import java.util.List;

public class SortArrayBST {
 public TreeNode sortArrayToBST(int[] nums){
     return helper(nums, 0, nums.length - 1);

 }
 public TreeNode helper(int[] nums,int left,int right){
     if(left>right){
         return null;
     }
     int mid=(left+right)/2;
     TreeNode root=new TreeNode(nums[mid]);
     root.setLeft(helper(nums,left,mid-1));
     root.setRight(helper(nums,mid+1,right));
     System.out.println(root.getValue());
     return root;
 }

    public static void main(String[] args) {
        SortArrayBST arrayBST= new SortArrayBST();
        int[] nums=new int[]{-10,-5,-3,0,1,3,5,9};
       TreeNode  treeNode =arrayBST.sortArrayToBST(nums);


    }
}
