package dp.knapsack01;

public class Knapsack01 {

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;

        int maxProfit = maxProfit(val, wt, W);
        System.out.println(maxProfit);
    }

    public static int maxProfit(int val[], int wt[], int W) {

        int maxProfitTable[][] = new int[wt.length + 1][W + 1];

        for (int i = 0; i < wt.length + 1; i++) {
            maxProfitTable[i][0] = 0;
        }

        for (int i = 1; i <= wt.length; i++) {

            for (int w = i; w <= W; w++) {
                if (wt[i - 1] > w) {
                    maxProfitTable[i][w] = maxProfitTable[i - 1][w];
                } else {
                    maxProfitTable[i][w] = Math.max(val[i - 1] + maxProfitTable[i][w - wt[i - 1]], maxProfitTable[i - i][w]);
                }
            }
        }
        return maxProfitTable[wt.length][W];
    }
}

