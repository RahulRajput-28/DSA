class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int h=height.length-1;
        int  maxarea=0;

        while(l<h){
            int minHeight=Math.min(height[l],height[h]);
            int area=minHeight*(h-l);
            maxarea=Math.max(area,maxarea);

            if(height[l]<=height[h]){
                l++;
            }else{
                h--;
            }
        }

        return maxarea;
    }
}