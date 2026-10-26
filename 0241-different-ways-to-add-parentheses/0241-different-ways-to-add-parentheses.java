//T.C : O(n*2^n)
//S.C : O(2^n) //The result vector stores all possible outcomes. The number of results is at most exponential in terms of the number of operators, so the space required to store the results is O(2^n).

class Solution {
    public List<Integer> solve(String expression) {
        int n = expression.length();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {

            char ch = expression.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*') {

                List<Integer> leftList = solve(expression.substring(0, i));
                List<Integer> rightList = solve(expression.substring(i + 1));

                for(int x: leftList) {
                    for(int y: rightList) {

                        if(ch == '+') {
                            result.add(x + y);
                        }
                        else if(ch == '-') {
                            result.add(x - y);
                        }
                        else {
                            result.add(x * y);
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        return result;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }
}