// TC: O(n)

class Solution {
    public boolean allZero(int[] freq) {

        for(int f: freq) {
            if(f != 0) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();

        int[] freq = new int[26];
        for(char ch: p.toCharArray()) {
            freq[ch - 'a']++;
        }

        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        while(j < m) {

            char ch = s.charAt(j);
            freq[ch - 'a']--;

            if(j - i + 1 == n) {

                if(allZero(freq)) {
                    list.add(i);
                }

                char prevCh = s.charAt(i);
                freq[prevCh - 'a']++;
                i++;
            }

            j++;
        }

        return list;
    }
}