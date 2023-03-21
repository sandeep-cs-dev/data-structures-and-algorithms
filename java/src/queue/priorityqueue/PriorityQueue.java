package queue.priorityqueue;

import java.lang.reflect.Array;
import java.util.*;

public class PriorityQueue {
    private List<Integer> pqueue;

    public PriorityQueue() {
        this.pqueue = new ArrayList<Integer>();
    }

    public int maximum() {
        if (this.pqueue.size() > 0)
            return this.pqueue.get(0);
        else
            return Integer.MIN_VALUE;
    }

    private void swap(int index1, int index2) {
        int tmp = this.pqueue.get(index1);
        this.pqueue.set(index1, this.pqueue.get(index2));
        this.pqueue.set(index2, tmp);
    }

    private void heapify(int nodeInd, int len) {
        int left = 2 * nodeInd + 1;
        int right = 2 * nodeInd + 2;
        //int len = arr.length;

        int maxInd = nodeInd;

        if (left < len && this.pqueue.get(left) > this.pqueue.get(nodeInd)) {
            maxInd = left;
        }
        if (right < len && this.pqueue.get(right) > this.pqueue.get(maxInd))
            maxInd = right;

        if (maxInd != nodeInd && maxInd >= 0) {
            swap(maxInd, nodeInd);
            //System.out.println(Arrays.toString(arr));
             heapify(maxInd, len);   //  check at new index for further disturbance in heap
        }
    }

    // It removes and return the maximum element from the Arr.
    public int extractMaximum() {
        int queueLen = this.pqueue.size();

        if (queueLen > 0) {
            int max = this.pqueue.get(0);
            this.pqueue.set(0, this.pqueue.get(queueLen - 1));
            this.pqueue.remove(queueLen - 1);
            this.heapify(0, queueLen-1);//now size is less by 1
            return queueLen;
        } else {
            return Integer.MIN_VALUE;
        }
    }
/*  - It increases the key of element stored at index i in Arr to new value val.
           9
        7     8
     6   5   4   3

  */

    public void increaseVal(int i, int val) {

        if (this.pqueue.get(i) > val || i==0)
            return;
        else {
            for (int k = i; k > 0;) {

                int kth = this.pqueue.get(k);
               // System.out.println(k);
                int kthParentInd = k / 2;

                kthParentInd = (k % 2 == 0 && k > 0) ? kthParentInd - 1 : kthParentInd;

                 //System.out.println("kth:parent "+k+":"+kthParentInd);
                int kthParentVal = this.pqueue.get(kthParentInd);

                if (kthParentVal < kth) {
                    this.swap(k, kthParentInd);
                    k = kthParentInd;
                }
            }
        }
    }

    public void add(int val) {
        this.pqueue.add(val);
        this.increaseVal(this.pqueue.size() - 1,val);
    }

    public void printQueue() {
        System.out.println(Arrays.toString(this.pqueue.toArray()));
    }
}