class MinStack {

    long min=0;
    Stack<Long> stack=new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        long valL=val;
        if(stack.isEmpty()) {
            stack.push(valL);
            min=valL;
        } else {
            if(valL>=min) {
                stack.push(valL);
            } else {
                stack.push((2*valL)-min);
                min=valL;
            }
        } 
    }
    
    public void pop() {
        long val=stack.pop();
        if(val<min) {
            min=(2*min)-val;
        }
    }
    
    public int top() {
        long val=stack.peek();
        return (int) (val<min?min:val);
    }
    
    public int getMin() {
        return (int) min;
    }
}