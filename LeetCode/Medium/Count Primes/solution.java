class Solution {
    public int countPrimes(int n) {
        int count=0;

        boolean[] notprime=new boolean[n];

        for(int i=2;i<n;i++){
            if(!notprime[i]){
                for(int j=i*2;j<n;j+=i){
                    notprime[j]=true;
                }
                count++;
            }
        }

        return count;
    }
}