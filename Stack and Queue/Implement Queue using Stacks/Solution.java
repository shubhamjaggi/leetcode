class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input=new Stack<>();
        output=new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        transferIfOutputEmpty();
        return output.pop();
    }
    
    public int peek() {
        transferIfOutputEmpty();
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    private void transferIfOutputEmpty() {
        if(output.isEmpty()) {
            while(!input.isEmpty()) output.push(input.pop());
        }
    }
}