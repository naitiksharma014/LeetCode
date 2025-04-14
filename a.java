//A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).


class Solution {
    long M=1000000007;

    public long findPower(long a, long b){
        if(b==0){
            return 1;
        }

        long half=findPower(a, b/2);
        long result=(half*half)%M;

        if(b%2==1){
            result=(result*a)%M;
        }
        return result;
    }
    public int countGoodNumbers(long n) {
    //    return (long) (findPower(5,(n+1)/2)*findPower(4,n/2)) % M;
        long even=(n+1)/2;
        long odd=n/2;
        long first=findPower(5,even)%M;
        long second=findPower(4,odd)%M;

        return (int)((first * second)%M);
        
    }
}