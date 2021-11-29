package com.example;

public interface PriorityQueueInterface
{
    public void enqueue(Process p) throws HeapException;

    public Process dequeue() throws HeapException;

    public boolean isEmpty();

    public void update(Process next, int timeToIncrementPriority, int maxPriority);
	
}
