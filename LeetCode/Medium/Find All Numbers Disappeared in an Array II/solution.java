class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {

        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);

        int expected=lower;

        for(int num:nums){
            if(num<expected){
                continue;
            }

            if(num>upper){
                break;
            }

            if(num>expected){
                ans.add(Arrays.asList(expected,num-1));
            }

            expected=num+1;

            
        }

        if(expected<=upper){
            ans.add(Arrays.asList(expected,upper));
        }

        return ans;
    }
}