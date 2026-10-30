class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int n=nums.length/3;

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            if(map.get(nums[i])>n){
                set.add(nums[i]);
            }
        }

        return new ArrayList<>(set);
    }
}