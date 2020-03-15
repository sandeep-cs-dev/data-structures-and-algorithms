package queue.priorityqueue;

public class TestPQueue {

    public static void main(String args[]) {

        PriorityQueue priorityQueue = new PriorityQueue();

        for (int i = 1; i <10; i++) {
            priorityQueue.add(i);
            //priorityQueue.printQueue();
        }

        for (int i = 1; i <10; i++) {
            System.out.println(priorityQueue.extractMaximum());
        }
    }
}