class Solution {
    public String reverseWords(String s) {
        String arr[] = s.split(" ");
        StringBuilder st = new StringBuilder();
       
        for(int i=arr.length-1;i>=0;i--){
           // System.out.println(arr[i]+" "+i);
            if(arr[i]=="") continue;
            
                st.append(arr[i]+ " ");
             
        }
        return st.toString().trim();
    }
}