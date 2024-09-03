class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Stack<Integer>> valTracker = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if (valTracker.containsKey(nums[i])) {
                Stack<Integer> tmp = valTracker.get(nums[i]);
                tmp.push(i);
                valTracker.put(nums[i], tmp);
            }
            else {
                Stack<Integer> tmp = new Stack<>();
                tmp.push(i);
                valTracker.put(nums[i], tmp);
            }
        }

        Arrays.sort(nums);

        int i=0, j=nums.length-1;
        while(i<j) {
            int sum = nums[i]+nums[j];
            if(sum<target) i++;
            else if(sum>target) j--;
            else {
                Stack<Integer> tmpI = valTracker.get(nums[i]);
                Stack<Integer> tmpJ = valTracker.get(nums[j]);
                return new int[] { tmpI.pop(), tmpJ.pop() };
            }
        }

        return new int[] { 0, 0 };
    }
}