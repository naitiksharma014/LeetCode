class Solution {
    private final int M = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t) {
        int[] mp = new int[26];

        for (char ch : s.toCharArray()) {
            mp[ch - 'a']++;
        }

        for (int count = 1; count <= t; count++) {
            int[] temp = new int[26];

            for (int i = 0; i < 26; i++) {
                char ch = (char) (i + 'a');
                int freq = mp[i];

                if (ch != 'z') {
                    temp[(ch + 1) - 'a'] = (temp[(ch + 1) - 'a'] + freq) % M;
                } else {
                    temp['a' - 'a'] = (temp['a' - 'a'] + freq) % M;
                    temp['b' - 'a'] = (temp['b' - 'a'] + freq) % M;
                }
            }

            mp = temp;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + mp[i]) % M;
        }

        return result;
    }
}