// TC: O(3 × 2ⁿ⁻¹) ≈ O(2ⁿ)
// SC: O(n)

class Solution {
    int count = 0;
    String result = "";

    public void solve(int n, int k, char[] arr, StringBuilder sb){
        if(sb.length() == n){
            count++;
            
            if(count == k){
                result = sb.toString();
            }
            return;
        }

        for(int i = 0; i < 3; i++){

            char curr = arr[i];
            if(sb.length() > 0 && sb.charAt(sb.length() - 1) == curr) continue;

            sb.append(curr);                        // Append
     
            solve(n, k, arr, sb);                   // Explore
    
            sb.deleteCharAt(sb.length() - 1);       // Backtrack
        }
    }

    public String getHappyString(int n, int k) {
        char[] arr = {'a','b','c'};

        solve(n, k, arr, new StringBuilder());

        return result;
    }
}