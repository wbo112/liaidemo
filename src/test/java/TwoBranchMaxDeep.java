

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 二叉树的最大深度
 */
public class TwoBranchMaxDeep {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.getLeft());
            int rightHeight = maxDepth(root.getRight());
            int maxDepth = Math.max(leftHeight, rightHeight) + 1;
            return maxDepth;
        }
    }

    public void create(int[] datas, List<TreeNode> list) {
        //将数组里面的东西编程节点的形式
        for (int i = 0; i < datas.length; i++) {
            TreeNode node = new TreeNode(datas[i]);
            list.add(node);
        }
        //节点关联成树
        for (int index = 0; index < list.size() / 2 - 1; index++) {
            list.get(index).setLeft(list.get(index * 2 + 1));
            //编号为n的节点他的左子节点编号为2*n  右子节点编号为2*n+1 但是因为list的编号从0开始，所以换是要加+1
            list.get(index).setRight(list.get(index * 2 + 2));
        }

        //单独处理最后一个父节点，list.size()/2-1进行设置，避免单独孩子情况
        int index = list.size() / 2 - 1;
        list.get(index).setLeft(list.get(index * 2 + 1));
        if (list.size() % 2 == 1) {
            //如果有奇数个节点，最后一个父节点才有右子节点
            list.get(index).setRight(list.get(index * 2 + 2));
        }
    }

    //先序遍历
//    先序遍历过程：
//            （1）访问根节点；
//            （2）采用先序递归遍历左子树；
//            （3）采用先序递归遍历右子树；
public  void preTraversal(TreeNode node){
        if(node ==null){
            return;
        }
    System.out.print(node.getValue()+" ");
        preTraversal(node.getLeft());
        preTraversal(node.getRight());
}

//    中序遍历：
//            （1）采用中序遍历左子树；
//            （2）访问根节点；
//            （3）采用中序遍历右子树
    public void midTraversal(TreeNode node){
        if (node == null)
            return;
        midTraversal(node.getLeft());
        System.out.print(node.getValue()+" ");
        midTraversal(node.getRight());
    }

    //后序遍历
//            （1）采用后序递归遍历左子树；
//            （2）采用后序递归遍历右子树；
//            （3）访问根节点；
    public void postTraversal(TreeNode node){
        if (node == null)
            return;
        postTraversal(node.getLeft());
        postTraversal(node.getRight());
        System.out.print(node.getValue()+" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs=str.split(",");
        int[] datas = new int[strs.length];
        for(int i=0;i<strs.length;i++){
            datas[i] =Integer.parseInt(strs[i]);
        }
        TwoBranchMaxDeep twoBranchTree = new TwoBranchMaxDeep();
        List<TreeNode> treeNodes = new ArrayList<>();
        twoBranchTree.create(datas, treeNodes);
        twoBranchTree.maxDepth(treeNodes.get(0));
            System.out.println(twoBranchTree.maxDepth(treeNodes.get(0)));
        twoBranchTree.preTraversal(treeNodes.get(0));

    }
}

