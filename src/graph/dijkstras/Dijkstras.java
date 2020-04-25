package graph.dijkstras;


import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstras {

    public static void main(String[] args) {

      int nodes []  =    {1,2,3,4,5};
      int [] [] graph =  {{0,6,0,1,0},{6,0,5,0,2},{0,5,0,0,5},{1,0,0,0,1},{0,2,5,1,0}};

      int [] dts =  shortestPath(graph,0);

      System.out.println(Arrays.toString(dts));

    }
/*     6
    A--------B\
    \      2 | \ 5
  1 \        |  / C
    D--------E/ 5
       1
 */

    static int  minDistance(int dist[], boolean [] visited)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < visited.length; v++)
            if (visited[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }

    public static int [] shortestPath(int [][] graph ,int sourceInd )  {
       boolean visited [] =  new boolean[graph.length];

       int dist []   =   new int[graph.length];       // distance from source

       for (int i=0;i<dist.length;i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i]=false;
         }
           dist[sourceInd]= 0;

         for (int j=0;j<graph.length;j++) {
                    // for each vertax of a graph;

              int minInd = minDistance(dist,visited);

              // update neighbours distance for thi vertax;
               System.out.println("min "+minInd);
             visited[minInd]=true;
              for(int k=0;k<graph[j].length;k++) {

                  if(visited[k]==false && minInd>=0 && graph[minInd][k]!=0) {
                    if((dist[minInd]+graph[minInd][k])<dist[k] && dist[minInd]!=Integer.MAX_VALUE) {
                        dist[k] = dist[minInd]+graph[minInd][k];
                    }
                  }
              }

         }
         return dist;
    }
}
