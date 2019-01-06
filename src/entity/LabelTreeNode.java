package entity;

public class LabelTreeNode {
    public String key;
    public String label;
    public LabelTreeNode left;
    public LabelTreeNode right;
    public LabelTreeNode(String key) {
        this.key = key;
        this.label = "";
        this.left = null;
        this.right = null;
    }
}
