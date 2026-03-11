//------------------------------------------------------------------------(Approach - 1)-----------------------------------------------------------------------------------------------------------------------
// Brute
// ⚙️ TC: O(log n)
// 💾 SC: O(log n)

class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
       
        String binary = Integer.toBinaryString(n);  // O(log n)
        StringBuilder sb = new StringBuilder();

        for(char ch: binary.toCharArray()){         // O(log n)
            
            if(ch == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }

        return Integer.parseInt(sb.toString(), 2);   // O(log n)
    }
}




//------------------------------------------------------------------------(Approach - 1)-----------------------------------------------------------------------------------------------------------------------
// Optimal
// TC: O(1)

class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;

        int bits = (int) Math.floor(Math.log(n) / Math.log(2)) + 1;
        int mask = (1 << bits) - 1;

        return n ^ mask;
    }
}
