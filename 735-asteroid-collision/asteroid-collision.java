class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int a :  asteroids){

            while(!st.isEmpty() && a < 0 && st.peek() > 0){   // Collision occurs when a < 0 AND st.peek() > 0

                int sum = a + st.peek();

                if(sum < 0){
                    st.pop();
                }
                else if(sum > 0){
                    a = 0;
                }
                else{
                    st.pop();
                    a = 0;
                }
            }

            if(a != 0){
                st.push(a);
            }
        }

        int n = st.size();
        int[] arr = new int[n];
        int i = n - 1;

        while(!st.isEmpty()){
            arr[i--] = st.pop();
        }

        return arr;
    }
}