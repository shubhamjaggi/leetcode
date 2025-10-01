class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if(token.equals("+")) {
                int op2=Integer.valueOf(stack.pop());
                int op1=Integer.valueOf(stack.pop());
                stack.push(op1+op2);
            } else if(token.equals("-")) {
                int op2=Integer.valueOf(stack.pop());
                int op1=Integer.valueOf(stack.pop());
                stack.push(op1-op2);
            } else if(token.equals("*")) {
                int op2=Integer.valueOf(stack.pop());
                int op1=Integer.valueOf(stack.pop());
                stack.push(op1*op2);
            } else if(token.equals("/")) {
                int op2=Integer.valueOf(stack.pop());
                int op1=Integer.valueOf(stack.pop());
                stack.push(op1/op2);
            } else {
                stack.push(Integer.valueOf(Integer.valueOf(token)));
            }
        }

        return stack.pop();
    }
}