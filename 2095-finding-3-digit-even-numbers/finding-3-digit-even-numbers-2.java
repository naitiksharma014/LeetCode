//Approach-1 (Trying all possibilities using 3 for loops for 3 digits)
//T.C : O(n^3 + SlogS), S = total 3 digits even numbers
//S.C : O(S)


class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }

                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];

                    if (num >= 100 && num % 2 == 0) {
                        set.add(num);
                    }
                }
            }
        }

        List<Integer> resultList = new ArrayList<>(set);
        Collections.sort(resultList);

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
