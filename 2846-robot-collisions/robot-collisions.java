// ⏱️ TC: O(n log n)
// 💾 SC: O(n)

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        // Lambda Function can only be applied on onjects
        Integer[] actualIdx = new Integer[n];
        for(int i = 0; i < n; i++) {
            actualIdx[i] = i;
        }

        // Sort actualIdx on the basis of positions with help of Lambda Function
        // O(n logn)
        Arrays.sort(actualIdx, (a, b)-> 
            Integer.compare(positions[a], positions[b]) 
        );

        Stack<Integer> st = new Stack<>();

        for(int currIdx: actualIdx) {

            // If robot is moving right → push to stack
            if(directions.charAt(currIdx) == 'R') {
                st.push(currIdx);
            }

            else {
                // Current robot is moving left → may collide with stack robots
                while(!st.isEmpty() && healths[currIdx] > 0) {

                    int topIdx = st.pop();
                
                    // Case 1: Stack robot is stronger
                    if(healths[topIdx] > healths[currIdx]) {
                        healths[topIdx] -= 1;
                        healths[currIdx] = 0;

                        st.push(topIdx);     // push back since it's still alive
                    }

                    // Case 2: Current robot is stronger
                    else if(healths[topIdx] < healths[currIdx]) {
                        healths[topIdx]   = 0;
                        healths[currIdx] -= 1;
                    }

                    // Case 3: Equal health → both die
                    else {
                        healths[topIdx]  = 0;
                        healths[currIdx] = 0;
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int health: healths) {

            if(health > 0) {
                result.add(health);
            }
        }

        return result;
    }
}