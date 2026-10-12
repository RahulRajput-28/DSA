class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int maxlen=0;

        HashMap<Character,Integer> map=new HashMap<>();

        while(r<s.length()){
            if(map.containsKey(s.charAt(r))){
                while(map.containsKey(s.charAt(r))){
                    map.remove(s.charAt(l));
                    l++;
                }
            }

            map.put(s.charAt(r),r);

            maxlen=Math.max(maxlen,r-l+1);

            r++;
        }

        return maxlen;
    }
}