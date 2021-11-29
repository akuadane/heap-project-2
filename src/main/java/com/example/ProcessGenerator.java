package com.example;

import java.util.Random;

public class ProcessGenerator implements ProcessGeneratorInterface {
    private double probability;

    Random random;

    ProcessGenerator(double probability){
        this.probability =probability;
        this.random = new Random();
    }
    ProcessGenerator(double probability,long seed){
        this.probability =probability;
        this.random= new Random(seed);
    }
    @Override
    public Process getNewProcess(int currentTime, int maxProcessTime, int maxPriority) {
        Process process = new Process();

        int priority = this.random.nextInt(maxPriority)+1;
        int timeRemaining= this.random.nextInt(maxProcessTime)+1;

        process.setPriority(priority);
        process.setTimeRemaining(timeRemaining);
        process.setArrivalTime(currentTime);

        return process;
    }

    @Override
    public boolean query() {
        if(this.probability>this.random.nextDouble())
            return true;
        return false;
    }
}
