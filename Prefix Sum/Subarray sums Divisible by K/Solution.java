class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;

        Map<Integer, Integer> remMap = new HashMap<>();
        remMap.put(0, 1);

        for(int i = 0, sum = 0; i < nums.length; i++){
            sum += nums[i];
            int rem = sum % k;
            rem = rem < 0 ? rem + k : rem;
            if (remMap.containsKey(rem)){
                res += remMap.get(rem);
                remMap.put(rem, remMap.get(rem) + 1);
            }else{
                remMap.put(rem, 1);
            }
        }

        return res;
    }
}