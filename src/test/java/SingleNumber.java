import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; ++i) {

            if (nums[i] == nums[i + 1]) {
                i++;
            } else {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }


    public static void main(String[] args) {
//        SingleNumber number = new SingleNumber();
//        int[] nums = new int[]{2, 2, 1};
//        System.out.println(number.singleNumber(nums));
        int[] nums= new int[]{1,2,3,4,5};
        List<ListNode> listNodeList = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            Solution s= new Solution();
            ListNode head=new ListNode(nums[i]);
            if(i<nums.length-1){
            head.next=new ListNode(nums[i+1]);
            listNodeList.add(s.reverseList(head));
            }
        }
        for(ListNode node:listNodeList){
            System.out.println(node.val);
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {

            ListNode nextNode=null;
            ListNode node = head;
            ListNode listNode = node;
            while (Objects.nonNull(node)) {

                listNode = node;
                node = node.next;
                listNode.next = nextNode;
                nextNode = listNode;

            }
            return listNode;
        }
    }
}
