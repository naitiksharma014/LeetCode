// TC: O(n logn)
// SC: O(n)

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        Integer[] actualIdx = new Integer[n];   // Lambda Function only works on Object
        for(int i = 0; i < n; i++){
            actualIdx[i] = i;
        }

        // Sort actualIdx on basis of position array using Lambda Function: O(n logn)
        Arrays.sort(actualIdx, (a, b)-> 
            Integer.compare(positions[a], positions[b])
        );

        Stack<Integer> st = new Stack<>();

        for(int currIdx: actualIdx){       //  TC: O(n)


            if(directions.charAt(currIdx) == 'R'){
                st.push(currIdx);
            } else{

                while(!st.isEmpty() && healths[currIdx] > 0){

                    int topIdx = st.pop();

                    if(healths[topIdx] > healths[currIdx]){
                        healths[topIdx] -= 1;
                        healths[currIdx] = 0;

                        st.push(topIdx);
                    } 
                    else if(healths[topIdx] < healths[currIdx]){
                        healths[topIdx] = 0;
                        healths[currIdx] -= 1;
                    }
                    else{
                        healths[topIdx] = 0;
                        healths[currIdx] = 0;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int health: healths){

            if(health > 0){
                result.add(health);
            }
        }

        return result;
    }
}