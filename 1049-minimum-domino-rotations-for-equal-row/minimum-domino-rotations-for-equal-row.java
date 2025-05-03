class Solution {
    public int find(int[] tops,int[] bottoms,int val){
        int n=tops.length;

        int swapTop=0,swapBottom=0;

        for(int i=0;i<n;i++){
            if(tops[i]!=val && bottoms[i]!=val) return -1;
            else if(bottoms[i]!=val){
                swapBottom++;
            }
            else if(tops[i]!=val){
                swapTop++;
            }
        }
        return Math.min(swapTop,swapBottom);
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result=Integer.MAX_VALUE;

        for(int val=1;val<7;val++){
            int swaps=find(tops,bottoms,val);

            if(swaps!=-1){
                result=Math.min(result,swaps);
            }
        }

        return result==Integer.MAX_VALUE? -1: result;
        
    }
}