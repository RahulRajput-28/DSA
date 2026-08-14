class Solution {
    public int maximumLengthSubstring(String s) {
        int left=0;
        
        int[] hash=new int[26];

        int maxlen=0;

        for(int right=0;right<s.length();right++){
            hash[s.charAt(right)-'a']++;

            while(hash[s.charAt(right)-'a']>2){
                hash[s.charAt(left)-'a']--;
                left++;
            }

            maxlen=Math.max(maxlen,right-left+1);
        }

        return maxlen;
    }
}