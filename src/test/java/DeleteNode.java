import com.fasterxml.jackson.databind.util.LinkedNode;
/**
 * 删除链表中的节点
 */
import java.util.*;

public class DeleteNode {
    public void delete(ListNode node){
        node.val=node.next.val;
        node.next=node.next.next;
    }

    //创建一个链表
public void create(int[] datas,List<ListNode> nodeList){
for(int i=0;i<datas.length;i++){
    ListNode listNode= new ListNode(datas[i]);
    if(i<datas.length-1){
        ListNode listNextNode= new ListNode(datas[i+1]);
        listNode.next=listNextNode;
    }
    nodeList.add(listNode);
}
}
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        LinkedList<ListNode> nodeList= new LinkedList<ListNode>();
        String str = sc.nextLine();
        String[] strs=str.split(",");
        int[] datas = new int[strs.length];
        for(int i=0;i<strs.length;i++){
            datas[i] =Integer.parseInt(strs[i]);
        }
        int delNode =sc.nextInt();
        DeleteNode delte= new DeleteNode();
        delte.create(datas,nodeList);
        LinkedList<ListNode> newNodeList= new LinkedList<ListNode>();
        if(delNode!=nodeList.getFirst().val ||delNode!=nodeList.getLast().val){
            for(int i =0;i<nodeList.size();i++){
                if(nodeList.get(i).val==delNode){
                    delte.delete(nodeList.get(i));
                }else{
             newNodeList.add(nodeList.get(i));
                }
            }
     for(int j=0;j<newNodeList.size();j++){
       System.out.println(newNodeList.get(j).val);
      }
        }

    }
}
class ListNode{
      int val;
     ListNode next;
     ListNode(int node){
         this.val=node;
         this.next=null;

     }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}


