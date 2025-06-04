class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> list = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        int n=candies.length;

        for(int i=0;i<n;i++){
            max = Math.max(max,candies[i]);
        }

        for(int i=0;i<n;i++){
            
            

            int temp = candies[i] + extraCandies;
            if(temp>=max){
                list.add(true);
            }
            else list.add(false);
        }
        return list;
    }
}