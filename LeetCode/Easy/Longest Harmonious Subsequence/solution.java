class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int maxi=0;
        for(int key: map.keySet()){
            if(map.containsKey(key+1)){
                maxi=Math.max(maxi,map.get(key)+map.get(key+1));
            }
        }

        return maxi;
    }
}