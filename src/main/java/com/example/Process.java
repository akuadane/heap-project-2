package com.example;

public class Process implements ProcessInterface,Comparable<Process>{
    private int priority,timeRemaining,arrivalTime,waitingTime;
    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public void setPriority(int priority) {
        this.priority= priority;
    }

    public void setTimeRemaining(int timeRemaining){this.timeRemaining=timeRemaining;}

    @Override
    public int getTimeRemaining() {
        return this.timeRemaining;
    }

    @Override
    public void decrementTimeRemaining() {
        this.timeRemaining--;
    }

    @Override
    public boolean finished() {
        return this.timeRemaining==0;
    }

    public void setArrivalTime(int arrivalTime){this.arrivalTime=arrivalTime;}
    @Override
    public int getArrivalTime() {
        return this.arrivalTime;
    }

    @Override
    public int getWaitingTime() {
        return this.waitingTime;
    }

    @Override
    public void incrementWaitingTime() {
        this.waitingTime++;
    }

    @Override
    public void resetWaitingTime() {
        this.waitingTime=0;
    }

    @Override
    public int compareTo(Process o) {
        if(this.priority>o.getPriority())
            return 1;
        else if(this.priority==o.getPriority()){
            if(this.getArrivalTime()<=o.getArrivalTime())
                return 1;
            else return 0;
        }
        return 0;
    }
}
