class Solution {
    public void twoSum( int[] nums , int k , List<List<Integer>> result , int tar ){
        int i = k; int n = nums.length;
        int j = n - 1;

        while( i < j ){
            if( nums[i] + nums[j] > tar ){
                j--;
            }
            else if( nums[i] + nums[j] < tar ){
                i++;
            }
            else{
                result.add( Arrays.asList( -tar , nums[i] , nums[j] ) );

                while( i < j && nums[i] == nums[i + 1] ){
                    i++;
                } 
                while( i < j && nums[j] == nums[j - 1] ){
                    j--;
                }
                
                i++;
                j--;
            }
            
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
       
       if( n < 3 ){
           return new ArrayList<>();
        }

       List<List<Integer>> result = new ArrayList<>();
       Arrays.sort( nums );

       for( int i = 0 ; i < n - 2 ; i++ ){
            if( i != 0 && nums[i] == nums[i - 1] ){
             continue;
            }
            twoSum( nums , i + 1 , result , - nums[i] );

        }

       return result;
    }
}