class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int prefixSum = 0;
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            prefixSum += nums[i];
            if(prefixSum == k) ans++;
            if(prefixMap.containsKey(prefixSum - k)) {
                ans += prefixMap.get(prefixSum - k);
            }
            if (prefixMap.containsKey(prefixSum)) {
                int count = prefixMap.get(prefixSum);
                prefixMap.put(prefixSum, count + 1);
            }
            else {
                prefixMap.put(prefixSum, 1);
            }
        }
        return ans;
    }
}