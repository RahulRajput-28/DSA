class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String map[]={
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };

        backTrack(digits,0,"",map,ans);

        return ans;
    }

    void backTrack(String digit,int index,String curr,String[] map,List<String> ans){
        if(index==digit.length()){
            ans.add(curr);
            return;
        }

        String letter=map[digit.charAt(index)-'0'];

        for(char ch:letter.toCharArray()){
            backTrack(digit,index+1,curr+ch,map,ans);
        }
    }
}