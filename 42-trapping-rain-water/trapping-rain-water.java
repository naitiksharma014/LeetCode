class Solution {
    public int trap(int[] height) {
        int n=height.length;

        //Left Array
        int leftArray[]=new int[n];
        leftArray[0]=height[0];
        for(int i=1;i<n;i++){
            leftArray[i]=Math.max(height[i],leftArray[i-1]);
        }

        //Right Array
        int rightArray[]=new int[n];
        rightArray[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightArray[i]=Math.max(height[i],rightArray[i+1]);
        }


        //Trapperd Water
        int trappedWater=0;

        //Loop
        for(int i=0;i<n;i++){
            int currWater=Math.min(leftArray[i],rightArray[i]);
            trappedWater+=currWater-height[i];
        }

        return trappedWater;



        
    }
}