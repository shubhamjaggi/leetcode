class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0; i < k; i++) {
            while(!dq.isEmpty() && dq.peekLast() < nums[i]) dq.removeLast();
            dq.offerLast(nums[i]);
        }

        int[] ans = new int[nums.length - k + 1];

        ans[0] = dq.peekFirst();
        
        for(int i = k, j = 0; i < nums.length; i++, j++) {
            if (dq.peekFirst() == nums[j]) {
                dq.poll();
            }
            while(!dq.isEmpty() && dq.peekLast() < nums[i]) dq.removeLast();
            dq.offerLast(nums[i]);
            ans[i - k + 1] = dq.peekFirst();
        }

        return ans;
    }
}