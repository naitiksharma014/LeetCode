class Solution {
    public int maxDifference(String s) {
        int n = s.length();

        int freq[] = new int[26];

        int oddFreq  = 0; 
        int evenFreq = n + 1;

        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        for(int i=0 ; i<26 ;i++){
            if(freq[i] == 0){
                continue;
            }

            if(freq[i] % 2 == 0){
                evenFreq = Math.min(evenFreq , freq[i]);
            }
            else{
                oddFreq = Math.max(oddFreq , freq[i]);
            }
        }

        return oddFreq - evenFreq;
    }
}