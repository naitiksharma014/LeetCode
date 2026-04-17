// 🧠 Sorting + Binary Search
// ⏱️ TC: O(n logm)
// 💾 Sc: O(1)

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        int[] res = new int[n];
        Arrays.sort(potions);

        for(int i = 0; i < n; i++) {     // O(n)

            long spell = spells[i];
            int l = 0, r = m - 1;

            while(l <= r) {             // O(log m)

                int mid = l + (r - l) / 2;

                if(spell * potions[mid] < success) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            res[i] = m - l; 
        }

        return res;
    }
}