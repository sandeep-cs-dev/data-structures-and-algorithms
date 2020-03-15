package random;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SortestPath2DArray {

    class Node {
        int x;
        int y;
        int DFS; // distance from source node

        Node(int x, int y, int DFS) {
            this.x = x;
            this.y = y;
            this.DFS = DFS;
        }
    }


    public int sortestPath(char[][] grid, Node source) {

        Queue<Node> queue = new LinkedList<Node>();
        Node start = new Node(0, 0, 0);
        queue.add(start);
        int M = grid.length;
        int N = grid[0].length;
        while (!queue.isEmpty()) {

            Node current = queue.poll();

            char currentNodeVal = grid[current.x][current.y];
            grid[current.x][current.y] = '0';
            if (currentNodeVal == 'D')
                return current.DFS;

            if (current.x - 1 >= 0 && grid[current.x - 1][current.y] != '0') {
                queue.add(new Node(current.x - 1, current.y, current.DFS + 1));
                 System.out.println("up");
            }
            if (current.x + 1 < M && grid[current.x + 1][current.y] != '0') {
                queue.add(new Node(current.x + 1, current.y, current.DFS + 1));
                System.out.println("down");
            }
            if (current.y + 1 < N && grid[current.x][current.y + 1] != '0') {
                queue.add(new Node(current.x, current.y+1, current.DFS + 1));
                System.out.println("right");
            }
            if (current.y - 1 >= 0 && grid[current.x][current.y - 1] != '0') {
                queue.add(new Node(current.x, current.y - 1, current.DFS + 1));
                System.out.println("left");
            }
        }
        return -1;
    }
}

public class SortestPath2DArrayTest {

    public static void main(String args[]) {

        char grid[][] = {{'0', '*', '0', 'S'},
                {'*', '0', '*', '*'},
                {'0', '*', '*', '*'},
                {'D', '*', '*', '*'}};

        SortestPath2DArray sp2d = new SortestPath2DArray();
        SortestPath2DArray.Node source = sp2d.new Node(0, 3, 0);
        int ans = sp2d.sortestPath(grid, source);
        System.out.println("Sfds " + ans);
    }

}
