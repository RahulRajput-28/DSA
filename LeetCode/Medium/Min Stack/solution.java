class MinStack {
    Stack<Integer> stack;
    Stack<Integer> copy;
    public MinStack() {
        stack=new Stack<>();
        copy=new Stack<>();
    }
    
    public void push(int value) {
        if(copy.isEmpty() || copy.peek()>=value){
            copy.push(value);
        }
        stack.push(value);
    }
    
    public void pop() {
        if(stack.peek().equals(copy.peek())){
            copy.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return copy.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */