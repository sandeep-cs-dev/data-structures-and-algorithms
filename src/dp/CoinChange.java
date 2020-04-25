package dp;

public class CoinChange {


    public static void main(String[] args) {


        int coins[] =  {9, 6, 5, 1};
        int V =11;
        int ans = coinChange(coins,V);
        System.out.println("Ans "+ans);

    }

    static  int coinChange( int [] a,int V) {

         int [] coinChangeDp =  new int[V+1];
         for (int i=0;i<coinChangeDp.length;i++) {

             coinChangeDp[i]= Integer.MAX_VALUE;
         }
         coinChangeDp[0]=0;
       for (int i=0;i<a.length;i++) {

           for(int j=1;j<=V;j++) {

               if(a[i]<=j){
                   int sub_res = coinChangeDp[j-a[i]];
                   if (sub_res != Integer.MAX_VALUE && sub_res + 1 < coinChangeDp[j])
                       coinChangeDp[j] = sub_res + 1;

               }
            }
       }
       return  coinChangeDp[V];

    }

}
