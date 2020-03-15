package dp.subsetsum;

public class SubsetSum {

public static void main (String ...args) {

    int set [] =   {2,4,6,10};
    int sum = 16;

  }

  public static boolean subSetSum(int arr [],int sum) {

     boolean subset [][] = new boolean[arr.length+1][sum+1];
     // non zero sum can not be possible  by having no element

      int n = arr.length+1;
      for(int i=0;i<=sum;i++) {
          subset[0][i]= false;
        }
      // sum zero can be obtained by having empty set
      for(int i=0;i<=n;i++) {
          subset[i][0]= true;
       }

        for ( int i=1;i<=n;i++) {

             for( int j=1;j<sum;j++) {

                 if(arr[i]>sum) {
                     subset[i][j] = subset[i][j-1];
                 }
                subset[i][j] =   subset[i-1][j] | subset[i-1][j-arr[i-1]];
             }
           }
          return subset[arr.length+1][sum+1];
     }
}
