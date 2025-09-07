class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> candidates = new LinkedList<>();
        int ans[] = new int[n-k+1]; // there will be exactly n-k+1 windows

        for(int i=0; i<k; i++) updateCandidatesOnAddition(candidates, i, nums); // prepare candidates for first window

        // at every window, SWM will be nums[candidates.peekFirst()]
        ans[0]=nums[candidates.peekFirst()];

        for(int i=1; i<(n-k+1); i++) {
            int toBeRemoved=i-1;
            int toBeAdded=i+k-1;

            if(candidates.peekFirst()==toBeRemoved) candidates.poll();
            updateCandidatesOnAddition(candidates, toBeAdded, nums);

            // at every window, SWM will be nums[candidates.peekFirst()]
            ans[toBeAdded-k+1]=nums[candidates.peekFirst()];
        }

        return ans;
    }

    // runs on every inclusion to the current window
    private void updateCandidatesOnAddition(Deque<Integer> candidates, int toBeAdded, int[] nums) {
        // remove all elements from the last that are smaller than the element whose index is to be added
        while(!candidates.isEmpty() && nums[candidates.peekLast()]<nums[toBeAdded]) candidates.removeLast();

        // now add the index toBeAdded
        candidates.offerLast(toBeAdded);
    }
}