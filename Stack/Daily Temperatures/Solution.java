class Solution {
    public int[] dailyTemperatures(int[] temps) {
        // use monotonic stack approach => decreasing order from bottom to top
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[temps.length];
        for(int i=temps.length-1;i>=0;i--) {
            while(!stack.isEmpty() && temps[i]>=temps[stack.peek()]) stack.pop();
            if(!stack.isEmpty()) res[i]=stack.peek()-i;
            stack.push(i);
        }
        return res;
    }
}