package com.company.model;

public class Job {
    public int start, finish;

    public Job(int start, int finish)
    {
        this.start = start;
        this.finish = finish;
    }

    public static Job of(int a, int b)
    {
        return new Job(a, b);
    }

    @Override
    public String toString() {
        return "(" + this.start + ", " + this.finish + ")";
    }
}
