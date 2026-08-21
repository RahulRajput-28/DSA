class Solution {
    public String[] findRelativeRanks(int[] score) {
        Integer[] index=new Integer[score.length];

        for(int i=0;i<score.length;i++){
            index[i]=i;
        }

        Arrays.sort(index,(a,b)->score[b]-score[a]);

        String[] ans=new String[score.length];

        for(int i=0;i<score.length;i++){
            int org=index[i];
            if(i==0){
                ans[org]="Gold Medal";
            }else if(i==1){
                ans[org]="Silver Medal";
            }else if(i==2){
                ans[org]="Bronze Medal";
            }else{
                ans[org]=String.valueOf(i+1);
            }
        }

        return ans;
    }
}