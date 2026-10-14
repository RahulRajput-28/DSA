class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];

        helper(li,ans,visited,nums);

        return ans;
    }

    void helper(List<Integer> li,List<List<Integer>> ans,boolean[] visited,int[] nums){
        if(li.size()==nums.length){
            ans.add(new ArrayList<>(li));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }

            li.add(nums[i]);
            visited[i]=true;

            helper(li,ans,visited,nums);

            li.remove(li.size()-1);
            visited[i]=false;
        }
    }
}