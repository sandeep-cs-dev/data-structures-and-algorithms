package graph.prims;

import java.util.Arrays;

public class Prims {

    public static void main(String[] args) {

        int nodes[] = {1, 2, 3, 4, 5};
        //int[][] graph = {{0, 6, 0, 1, 0}, {6, 0, 5, 0, 2}, {0, 5, 0, 0, 5}, {1, 0, 0, 0, 1}, {0, 2, 5, 1, 0}};
          int [][] graph =  { { 0, 2, 0, 6, 0 },
                  { 2, 0, 3, 8, 5 },
                  { 0, 3, 0, 0, 7 },
                  { 6, 8, 0, 0, 9 },
                  { 0, 5, 7, 9, 0 } } ;
        int[] mst = primsAlgo(graph, 0);

        System.out.println(Arrays.toString(mst));

    }
/*     6
    A--------B\
    \      2 | \ 5
  1 \        |  / C
    D--------E/ 5
       1
 */

    static int min(int weight[], boolean[] visited) {
        int min= Integer.MAX_VALUE;
        int minInd = 0;
        for (int k = 0; k < weight.length; k++) {
                if (visited[k] == false && min>weight[k]) {
                    min = weight[k];
                    minInd=k;
                }
        }
        return minInd;
    }

    public static int[] primsAlgo(int graph[][], int sourceInd) {

        boolean visited[] = new boolean[graph.length];

        int weight[] = new int[graph.length];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
            weight[i] = Integer.MAX_VALUE;
        }

        weight[sourceInd] = 0;
        int parentOf[] = new int[graph.length];
        parentOf[sourceInd] =0;

        for (int i = 0; i < graph.length; i++) {
            // extract min
            System.out.println(Arrays.toString(weight));
            int min = min(weight, visited); // source or parent
            System.out.println("mii"+min);
            visited[min] = true;
            for(int j=0;j<graph.length;j++) {

                if (visited[j] == false  && graph[min][j] != 0 && weight[j] > graph[min][j] && weight[min]!=Integer.MAX_VALUE) {
                   // System.out.println("jdsjds"+j);
                    weight[j] = graph[min][j];
                    parentOf[j] = min;
                }


            }
        }
       return parentOf;
    }
}
