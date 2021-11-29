package com.example;

public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface {
    /**
     * MyPriorityQueue is an implementation of MaxHeap, that allows to
     * get an item with the highest priority when we call dequeue.
     * */
    @Override
    public void enqueue(Process p) throws HeapException {
            this.insertKey(p);

    }

    @Override
    public Process dequeue() throws HeapException {return this.extractMax();}

    @Override
    public boolean isEmpty() {
        return this.getHeapSize()==0;
    }

    @Override
    public void update(Process next, int timeToIncrementPriority, int maxPriority) {
        next.resetWaitingTime();
        for(int i=1;i<=this.getHeapSize();i++){
         Process process = this.getItem(i);
                process.incrementWaitingTime();

               if(process.getWaitingTime()>=timeToIncrementPriority){
                   process.resetWaitingTime();
                   if(process.getPriority()<maxPriority){
                       try {
                           this.increaseKey(i,process.getPriority()+1);
                       } catch (HeapException e) {
                           e.printStackTrace();
                       }
                   }
               }
        }
    }
}
