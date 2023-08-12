class Solution {
    public int subarraySum(int[] nums, int k) {

        int res = 0;
        int currSum = 0;

        Map<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0, 1);

        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            if (sumCountMap.containsKey(currSum - k)) res += sumCountMap.get(currSum - k);
            sumCountMap.put(currSum, sumCountMap.containsKey(currSum) ? sumCountMap.get(currSum) + 1 : 1);
        }

        return res; 
    }
}