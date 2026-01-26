class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;

        for(int i = 0; i < n - 1; i++){

            int d = arr[i + 1] - arr[i];
            
            if(d < diff){
                diff = d;
                list.clear();
                list.add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
            }
            else if(d == diff){
                list.add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
            }
        }

        return list;
    }
}