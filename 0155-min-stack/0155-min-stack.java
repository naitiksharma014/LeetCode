// TC: O(1)
// SC: (n)

class Pair {
    int val, minVal;

    Pair(int val, int minVal) {
        this.val = val;
        this.minVal = minVal;
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
            int minValue = Math.min(value, st.peek().minVal);
            st.push(new Pair(value, minValue));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().minVal;
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