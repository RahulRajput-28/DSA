class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str=new StringBuilder();
        int depth=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(depth>0){
                    str.append(s.charAt(i));
                }
                depth++;
            }else{
                if(depth>1){
                    str.append(s.charAt(i));
                }
                depth--;
            }
        }

        return str.toString();
    }
}