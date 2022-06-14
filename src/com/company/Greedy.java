package com.company;

import com.company.model.Pair;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Greedy {
    public static void SelectActivities(int s[], int f[])
    {

        // Vector to store results.
        ArrayList<Pair> ans = new ArrayList<>();

        // Minimum Priority Queue to sort activities in
        // ascending order of finishing time (f[i]).
        PriorityQueue<Pair> p = new PriorityQueue<>(
                (p1, p2) -> p1.first - p2.first);

        for (int i = 0; i < s.length; i++) {
            // Pushing elements in priority queue where the
            // key is f[i]
            p.add(new Pair(f[i], s[i]));
        }

        Pair it = p.poll();
        int start = it.second;
        int end = it.first;
        ans.add(new Pair(start, end));

        while (!p.isEmpty()) {
            Pair itr = p.poll();
            if (itr.second >= end) {
                start = itr.second;
                end = itr.first;
                ans.add(new Pair(start, end));
            }
        }
        System.out.println(
                "Following Activities should be selected. \n");

        for (Pair itr : ans) {
            System.out.println(
                    "Activity started at: " + itr.first
                            + " and ends at  " + itr.second);
        }
    }
}
