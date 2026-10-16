/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return check(root,p,q);
    }

    TreeNode check(TreeNode node, TreeNode p, TreeNode q){
        if(node==null){
            return null;
        }

        if(node==p || node==q){
            return node;
        }

        TreeNode left=check(node.left,p,q);
        TreeNode right=check(node.right,p,q);

        if(left!=null && right!=null){
            return node;
        }

        if(left!=null){
            return left;
        }

        return right;
    }
}