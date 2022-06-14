package com.company;
import com.company.model.Job;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dynamic {

    public static void findNonConflictingJobs(List<Job> jobs)
    {
        // sort the jobs according to increasing order of their start time
        Collections.sort(jobs, Comparator.comparingInt(x -> x.start));

        // `L[i]` stores the maximum non-conflicting jobs that end at i'th job
        List<List<Job>> L = new ArrayList<>();
        for (var job: jobs) {
            L.add(new ArrayList<>());
        }

        for (int i = 0; i < jobs.size(); i++)
        {
            // consider each `j` less than `i`
            for (int j = 0; j < i; j++)
            {
                // L[i] = Math.max(L[j]), where `jobs[j].finish` is less than
                // `jobs[i].start`
                if (jobs.get(j).finish < jobs.get(i).start &&
                        L.get(i).size() < L.get(j).size()) {
                    L.set(i, new ArrayList<>(L.get(j)));
                }
            }

            // `L[i]` ends at i'th job
            L.get(i).add(jobs.get(i));
        }

        // find the list having a maximum size
        List<Job> max = L.stream().max(Comparator.comparingInt(x -> x.size())).get();

        // print maximum non-conflicting jobs
        System.out.print(max);
    }

}
