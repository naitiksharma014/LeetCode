class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        int n=words.length;
        ArrayList<Integer>list=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            String ch=words[i];
            int m=ch.length();
            for(int j=0;j<m;j++){
                if(ch.charAt(j)==x){
                    list.add(i);
                    break; 
                }    
            }   
        }

        return list;
    }
}