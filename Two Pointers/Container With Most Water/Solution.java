class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;

        int maxWater = Integer.MIN_VALUE;

        do{

            int dist = end - start;
            int water;

            if (height[start] <= height[end]){
                water = dist * height[start];
                start++;
            }else{
                water = dist * height[end];
                end--;
            }
            maxWater = water > maxWater ? water : maxWater;

        }while(start < end);

        return maxWater;
    }
}