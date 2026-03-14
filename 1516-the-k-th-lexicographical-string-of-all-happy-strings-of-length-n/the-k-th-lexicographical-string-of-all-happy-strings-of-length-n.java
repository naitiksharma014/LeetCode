class Solution {
    int count = 0;
    String ans = "";
    char prev = '*';
    ArrayList<String> list = new ArrayList<>();

    public void solve(int n, int k, char[] arr, StringBuilder sb){
        if(sb.length() == n){
            list.add(sb.toString());
            return;
        }

        if(list.size() >= k) return;


        for(int i = 0; i < 3; i++){

            char curr = arr[i];
            if(sb.length() > 0 && sb.charAt(sb.length() - 1) == curr) continue;

            sb.append(curr);
    

            solve(n, k, arr, sb);
    
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public String getHappyString(int n, int k) {
        char[] arr = {'a','b','c'};

        solve(n, k, arr, new StringBuilder());

        if(list.size() < k) return "";

        return list.get(k - 1);
    }
}