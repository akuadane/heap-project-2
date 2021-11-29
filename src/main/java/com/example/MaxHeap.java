package com.example;

public class MaxHeap {
    /**
     * MaxHeap is one type of heap implementation that is used to get the maximum number in the heap, in O(1) time complexity.
     * An array is used to store the elements. If the array becomes full, it's size is doubled.
     * */
    private Process[] heap= new Process[10];
    private int heapSize=0;


    public void buildMaxHeap(){
        for(int i=this.getHeapSize();i>=1;i--){
            heapMaxify(i);
        }
    }

    public void heapMaxify(int i){
        int left= this.left(i);
        int right = this.right(i);
        int largest = i;
        if(left<=this.getHeapSize() && this.heap[left].compareTo(this.heap[i])==1){
             largest= left;
        }

        if(right<=this.getHeapSize() && this.heap[right].compareTo(this.heap[largest])==1){
             largest= right;
        }

        if(largest!=i){
            swap(largest,i);
            this.heapMaxify(largest);
        }

    }
    public Process getMaximum(){
        return this.heap[1];
    }
    public Process getItem(int index){
        if(index<=this.getHeapSize()){
            return this.heap[index];
        }
        return null;
    }
    public Process extractMax() throws HeapException {
        /**
         * Returns the largest element in the heap
         * It throws an exception when ever the heap is empty.
        */
        if(this.heapSize<1){
            throw new HeapException("Heap Underflow");
        }
        Process max = this.heap[1];
        this.heap[1]= this.heap[this.heapSize];
        this.decrementHeapSize();
        this.heapMaxify(1);

        return max;
    }

    public void increaseKey(int i, int key) throws HeapException {
        /**
         * Returns nothing
         * i is the index of item in the heap
         * key is the new and the increased priority key for item at index of i
         * It throws exception whenever the new key is smaller than the key already in the heap
         */
        if(this.heap[i].getPriority()>key)
            throw new HeapException("New key must be larger than current key");

        this.heap[i].setPriority(key);

        while(i>1 && this.heap[this.parent(i)].compareTo(this.heap[i])==0){

                    this.swap(i,parent(i));
                    i=parent(i);
        }
    }

    public void insertKey(Process process) throws HeapException {
        /**
         * Returns nothing
         * It inserts a new Process object into the heap
         * It throws an exception whenever this.increaseKey method call throws an exception
         */
        this.incrementHeapSize();
        int key= process.getPriority();
        process.setPriority(Integer.MIN_VALUE);
        this.heap[this.heapSize]=process;

        this.increaseKey(this.heapSize,key);

    }

    private int parent(int i){return i/2;}
    private int left(int i){
        return 2*i;
    }
    private int right(int i){
        return 2*i+1;
    }
    private void swap(int i, int j){
        Process tempProcess = this.heap[i];
        this.heap[i]=this.heap[j];
        this.heap[j]=tempProcess;
    }

    public int getHeapSize(){
        return this.heapSize;
    }
    public boolean isEmpty(){
        return this.heapSize==0;
    }

    public void incrementHeapSize(){
        if(this.heapSize+1 > this.heap.length-1){
            this.doubleHeapSize();
        }
        this.heapSize++;


    }
    public void decrementHeapSize(){
        this.heapSize--;
    }

    public void doubleHeapSize(){
        Process[] temp = new Process[this.heapSize*2];
       for (int i=1;i<=this.heapSize;i++){
           temp[i]=this.heap[i];
       }
       this.heap= temp;

    }
}
