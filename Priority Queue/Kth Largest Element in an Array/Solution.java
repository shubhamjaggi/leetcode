class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> numsQueue = Arrays.stream(nums).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        while(numsQueue.size() > k){
            numsQueue.poll();
        }

        return numsQueue.peek();
    }
}