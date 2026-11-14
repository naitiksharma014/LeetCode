// Time Complexity: O(n * 4ⁿ)
// Space Complexity: O(n * 4ⁿ) - including output
// Auxiliary Space: O(n)

class Solution {
    int n;
    ArrayList<String> result = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();

    public void solve(int idx, String digits, StringBuilder str) {
        if(idx >= n) {
            result.add(str.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String temp = map.get(digit);

        for(int i = 0; i < temp.length(); i++) {

            str.append(temp.charAt(i));

            solve(idx + 1, digits, str);

            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return result;

        n = digits.length();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder str = new StringBuilder();

        solve(0, digits, str);

        return result;
    }
}