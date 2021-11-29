package com.example;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MaxHeapTest {

    @Test()
    @DisplayName("Should insert a new node")
    public void insertTest(){
        /**
         * Tests if the insertKey method is working.
         * */
        MaxHeap heap = new MaxHeap();
        try {
            heap.insertKey(new Process());
            System.out.println(heap.getHeapSize());
        } catch (HeapException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Should extract the highest priority node")
    public void extractTest(){
        /**
         *This tests if the extractMax method is working as intended or not
         * We check if the returned max element is actually the max element, and
         * we also check if the size of the heap decreases when we extract an element.
         * */
        MaxHeap heap = new MaxHeap();
        for(int i=1;i<=10;i++){
            Process process = new Process();
            process.setPriority(i);
            process.setArrivalTime(i);

            try {
                heap.insertKey(process);
            } catch (HeapException e) {
                e.printStackTrace();
            }
        }
        try {
            assertEquals(10,heap.extractMax().getPriority());
            assertEquals(9,heap.getHeapSize());
        } catch (HeapException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Should expand the array when limit is reached")
    public void arrayExpansionTest(){
        /**
         * When a heap is initialized the internal array's length is of size 10.
         * Whenever the array is full, the method doubleHeapSize is called the size is doubled.
         * */
        MaxHeap heap = new MaxHeap();
        for(int i=1;i<=20;i++){
            Process process = new Process();
            process.setPriority(i);
            process.setArrivalTime(i);

            try {
                heap.insertKey(process);
            } catch (HeapException e) {
                e.printStackTrace();
            }
        }
        assertEquals(20,heap.getHeapSize());
    }
}