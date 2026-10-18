/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();

        traverse(root,ans);

        return ans;
    }

    void traverse(TreeNode temp,List<Integer> ans){
        if(temp==null){
            return;
        }

        traverse(temp.left,ans);
        ans.add(temp.val);
        traverse(temp.right,ans);
    }
}