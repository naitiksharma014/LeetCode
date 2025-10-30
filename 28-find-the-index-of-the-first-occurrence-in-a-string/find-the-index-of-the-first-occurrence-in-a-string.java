class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // if(m == 0) return -1;
        // if(n < m) return -1;
        // if(n == m) return 0;

        for(int i = 0 ; i <= n - m ; i++){

           for(int j = 0 ; j < m ; j++){

                if (haystack.charAt(i + j) != needle.charAt(j) ) break;

                if(j == m - 1) return i;
            }
        }

        return -1;
    }
}