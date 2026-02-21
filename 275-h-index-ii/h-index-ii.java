// TC: O(logn)

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0, high = n - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            int papers = n - mid;  // papers with citations >= citations[mid]

            if(citations[mid] >= papers){
                high = mid - 1;  // try to find smaller index
            }
            else{
                low = mid + 1;
            }
        }

        return n - low;
    }
}