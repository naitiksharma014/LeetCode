// TC: O(n)
// SC: O(no. of digits) = O(logn)

class Solution {
    List<Integer> list = new ArrayList<>();

    public void solve(int num, int n) {
        if(num > n) {
            return;
        }

        list.add(num);

        for(int i = 0; i < 10; i++) {
    
            int newNum = num * 10 + i;
            if(newNum > n) {
                return;
            }

            solve(newNum, n);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        
        for(int i = 1; i < 10; i++) {
            solve(i, n);
        }

        return list;
    }
}