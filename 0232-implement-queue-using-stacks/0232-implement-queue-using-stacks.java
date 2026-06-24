class MyQueue {

    Stack<Integer> primary = new Stack<>();
    Stack<Integer> secondary = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        primary.push(x);
    }
    
    public int pop() {
        if(!empty()){
            while(primary.size() != 0){
                secondary.push(primary.pop());
            }
            int removed = secondary.pop();
            while(secondary.size() != 0){
                primary.push(secondary.pop());
            }
            return removed;
        }
        return 0;
    }
    
    public int peek() {
        if(!empty()){
            while(primary.size() != 0){
                secondary.push(primary.pop());
            }
            int peek = secondary.peek();
            while(secondary.size() != 0){
                primary.push(secondary.pop());
            }
            return peek;
        }
        return 0;
    }
    
    public boolean empty() {
        return primary.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */