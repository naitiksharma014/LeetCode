// TC: O(1)
// SC: (n)

class Pair {
    int val1;
    int val2;

    Pair(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }
}

class MinStack {

    Stack<Pair> st = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int value) {
        
        if(st.isEmpty()) {
            st.push(new Pair(value, value));
        }
        else {
            int minVal = Math.min(st.peek().val2, value);
            st.push(new Pair(value, minVal));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val1;
    }
    
    public int getMin() {
        return st.peek().val2;
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