package datastructure;

import java.util.Optional;

public class RingBuffer<T> {
 int size;
 int head = -1;
 int tail = -1;
 T[] buffer;

/*
to visualize first thing it as one D array
If Head == tail  then queue is full

If tail == head  then there is only one element

 */


 public  RingBuffer ( int size) {
     this.size =size;
     buffer = (T[]) new Object[size];
 }

 public void enqueue ( T value) {
  if(isFull()){
    throw  new RuntimeException("Buffer is Full");
   }
   head = (head+1)%size;
   buffer[head]= value;
 }
 public Optional<T> dequeue() {
     tail = (tail+1)%size;
  if(isEmpty()){
   return Optional.empty();
  }
     T dQueuedElmenet;
     if(isLastElementInTheBuffer()){
         dQueuedElmenet = buffer[head];
        head = tail =-1;
     } else {
         dQueuedElmenet = buffer[tail];
       tail = (tail + 1) % size;
     }
     return  Optional.of(dQueuedElmenet);
 }

 public boolean isFull () {
  // if head next value (front is falling on the same index as on tail(rear )
   return  (head + 1) % size == tail;
 }
public boolean isEmpty () {
 return head==-1 &&  tail==-1;
}

public boolean isLastElementInTheBuffer () {
    return tail==head;
}

public Optional<T> peek () {
  if(head!=-1) {
    return Optional.of(buffer[head]);
  }
   return null;
}
}