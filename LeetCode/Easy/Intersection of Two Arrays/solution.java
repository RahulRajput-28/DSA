class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        ArrayList<Integer> li=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }

        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                li.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] fans=new int[li.size()];

        for(int i=0;i<li.size();i++){
            fans[i]=li.get(i);
        }
        return fans;
    }
}