class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high=0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]>high){
                high=piles[i];
            }
        }

        int low=1;

        while(low<high){
            int mid=(low+high)/2;
            
            if(canFinish(mid,piles,h)){
                high=mid;
            }else{
                low=mid+1;
            }
        }

        return low;

    }

    boolean canFinish(int k,int[] piles,int h){
        int hour=0;

        for(int i=0;i<piles.length;i++){
            hour+=(piles[i]+k-1)/k;
        }

        if(hour<=h){
            return true;
        }else{
            return false;
        }
    }
}