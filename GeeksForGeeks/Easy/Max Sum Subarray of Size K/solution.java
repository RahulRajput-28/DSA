class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int maxSum=0;
        
        for(int i=0;i<k;i++){
            maxSum+=arr[i];
        }
        
        int sum=maxSum;
        
        for(int i=k;i<arr.length;i++){
            sum=sum-arr[i-k]+arr[i];
            maxSum=Math.max(sum,maxSum);
        }
        
        return maxSum;
    }
}