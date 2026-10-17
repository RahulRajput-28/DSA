class Solution {
    public void nextPermutation(int[] nums) {
        int l=nums.length-2;

        while(l>=0 && nums[l]>=nums[l+1]){
            l--;
        }

        if(l>=0){
            int r=nums.length-1;

            while(nums[r]<=nums[l]){
                r--;
            }

            swap(nums,l,r);
        }

        reverse(nums,l+1,nums.length-1);
    }

    void swap(int[] arr,int l,int r){
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }

    void reverse(int[] arr,int start,int end){
        while(start<=end){
            swap(arr,start,end);

            start++;
            end--;
        }
    }
}