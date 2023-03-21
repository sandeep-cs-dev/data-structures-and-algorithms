package recursion;

public class LCS {
    public static void main (String[] args) {

       int ans = new LCS().LCS("ABCDEFGHIJ",10,"BDFHK",5);
       System.out.println(ans);
    }

    public int LCS (String A,int lenA, String B,int lenB) {
        // base case if either of string is of length 0, there will be no common string hence return zero
        if(lenA ==0 || lenB==0){
          return 0;
        }
        else if(A.charAt(lenA-1)==B.charAt(lenB-1)){
            // if there is a match then further repeat for length of respective string
            return 1+LCS(A,lenA-1,B,lenB-1);
          } else {
              // if there is no match then we have two choice to make
             // choice first: consider A with remaining of B
            // choice two consider B with remaining of A
            // since we want the Longest common substring we take max of two choice
             return Math.max(LCS(A,lenA,B,lenB-1),LCS(A,lenA-1,B,lenB));
          }
     }
}
