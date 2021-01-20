public class TreeNode{
    private int value;
    private TreeNode node;
    private TreeNode left;
    private TreeNode right;
    public TreeNode(int value){
        this.value=value;
        this.left=null;
        this.right=null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public String toString(){
        return this.value+"";
    }

    public TreeNode getNode() {
        return node;
    }

    public void setNode(TreeNode node) {
        this.node = node;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
