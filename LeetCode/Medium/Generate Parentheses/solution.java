class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        backtrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    void backtrack(List<String> ans,StringBuilder st,int open,int close,int n){
        if(st.length()==2*n){
            ans.add(st.toString());
            return;
        }

        if(open<n){
            st.append('(');
            backtrack(ans,st,open+1,close,n);
            st.deleteCharAt(st.length()-1);
        }

        if(close<open){
            st.append(')');
            backtrack(ans,st,open,close+1,n);
            st.deleteCharAt(st.length()-1);
        }
    }
}