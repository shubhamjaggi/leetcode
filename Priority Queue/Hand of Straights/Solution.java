class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer,Integer> freqMap=new HashMap<>();
        for(int val: hand) freqMap.put(val,freqMap.getOrDefault(val,0)+1);
        
        /* use min heap as every possible arrangement will start from its min card.
            => min heap to return the starting card for all the possible sequences */
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(freqMap.keySet());
        while(!minHeap.isEmpty()) {
            int start=minHeap.peek();
            for(int i=start;i<start+groupSize;i++) { // start from min val card and check for all the cards in the group
                if(freqMap.containsKey(i)) {
                    freqMap.put(i,freqMap.get(i)-1);
                    if(freqMap.get(i)==0) {
                        /* if min card val is not the one that got exhausted, there would be a hole in the future sequence
                            and cards cant be rearranged */
                        if(minHeap.peek()!=i) return false;
                        minHeap.poll();
                    }
                } else return false;
            }
        }
        return true;
    }
}