package dp.lcs;

public class LCS {


    public static void main(String[] args) {
        int ans = LCS.LCS("AKKKKKKKKC","ABC");
        System.out.println(ans);
    }

    public static int LCS(String A, String B) {

      int SIZE_A = A.length();
      int SIZE_B = B.length();
      int lcs [][] = new int[SIZE_A+1][SIZE_B+1];

      for(int i=0;i<=SIZE_A;i++){
          lcs[i][0]=0;
      }
        for(int i=0;i<=SIZE_B;i++){
            lcs[0][i]=0;
        }
        for(int i=1;i<=SIZE_A;i++) {
            for (int j = 1; j <= SIZE_B; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }
        return lcs[SIZE_A][SIZE_B];
    }
}
