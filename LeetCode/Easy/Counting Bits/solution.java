class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];

        for(int i=0;i<=n;i++){
            int n1=i;
            while(n1>0){
                int rem=n1%2;
                if(rem==1)ans[i]++;
                n1=n1/2;
            }
        }

        return ans;
    }
}