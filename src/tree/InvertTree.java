package tree;

import com.sun.source.tree.Tree;

public class InvertTree {


     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        InvertTree invertTree = new InvertTree();
        TreeNode left =  invertTree.new TreeNode(1,null,null);
        TreeNode right = invertTree.new TreeNode(2,null,null);
        TreeNode root =  invertTree.new TreeNode(0,left,right);
        TreeNode treeNode = invertTree(root);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.right.val);
    }

        public static TreeNode invertTree(TreeNode root) {

            if(root==null){
                return null;
            }
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            return root;
        }

}
