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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();

        if(root==null){
            return ans;
        }

        dfs(root,"",ans);

        return ans;
    }

    void dfs(TreeNode temp,String str,List<String> ans){
        str+=temp.val;

        if(temp.left==null && temp.right==null){
            ans.add(str);
            return;
        }

        str+="->";

        if(temp.left!=null){
            dfs(temp.left,str,ans);
        }

        if(temp.right!=null){
            dfs(temp.right,str,ans);
        }
    }
}