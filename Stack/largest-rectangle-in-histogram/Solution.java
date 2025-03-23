class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] prev = new int[heights.length];
        int[] next = new int[heights.length];

        Stack<Integer> stack = new Stack<>();

        for(int i=heights.length-1; i>=0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) stack.pop();
            next[i]=stack.isEmpty()?heights.length:stack.peek();
            stack.push(i);
        }

        stack.clear();

        for(int i=0; i<heights.length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) stack.pop();
            prev[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }

        prev[0]=-1; next[heights.length-1]=heights.length;

        int ans=0;
        for(int i=0; i<heights.length; i++) ans = Math.max((next[i]-prev[i]-1)*heights[i], ans);
        return ans;
    }
}