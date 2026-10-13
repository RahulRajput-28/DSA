class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();

        solve(0,ans,li,nums);

        return ans;
    }

    void solve(int index,List<List<Integer>> ans,List<Integer> li,int[] nums){
        if(index==nums.length){
            ans.add(new ArrayList<>(li));
            return;
        }

        li.add(nums[index]);
        solve(index+1,ans,li,nums);

        li.remove(li.size()-1);
        solve(index+1,ans,li,nums);
    }
}