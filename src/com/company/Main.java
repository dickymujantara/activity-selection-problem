package com.company;

import com.company.model.Job;
import java.util.Arrays;
import java.util.List;
import static com.company.Greedy.SelectActivities;

public class Main {

    public static void main(String[] args) {
        // Run Dynamic Program
        dynamicRun();
        // Run Greedy Program
        greedyRun();
    }

    static void greedyRun(){
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int finish[] = { 2, 4, 6, 7, 9, 9 };

        // Function call
        SelectActivities(start, finish);
    }

    static void dynamicRun(){
        List<Job> jobs = Arrays.asList(new Job(1, 4), new Job(3, 5),
                new Job(0, 6), new Job(5, 7),
                new Job(3, 8), new Job(5, 9),
                new Job(6, 10), new Job(8, 11),
                new Job(8, 12), new Job(2, 13),
                new Job(12, 14));
        Dynamic.findNonConflictingJobs(jobs);
    }

}
