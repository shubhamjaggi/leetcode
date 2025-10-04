class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length; Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-2;i++) {
            if(i>0 && nums[i-1]==nums[i]) continue; // skip duplicates for the first elem
            for(int[] pair:twoSum(nums,i+1,-nums[i])) {
                ans.add(Arrays.asList(nums[i],pair[0],pair[1]));
            }
        }
        return ans;
    }

    private List<int[]> twoSum(int[] nums,int start,int target) {
        List<int[]> pairs=new ArrayList<>();
        int left=start; int right=nums.length-1;
        while(left<right) {
            int currSum=nums[left]+nums[right];
            if(currSum<target) left++;
            else if(currSum>target) right--;
            else {
                pairs.add(new int[] { nums[left++],nums[right--] });
                while(left<right && nums[left]==nums[left-1]) left++; // skip duplicates for left
                while(left<right && nums[right]==nums[right+1]) right--; // skip duplicates for right
            }
        }
        return pairs;
    }
}