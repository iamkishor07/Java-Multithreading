package sol;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class pair implements Comparable<pair>
{
    int val;
    int freq;

    @Override
    public String toString() {
        return "pair{" +
                "val=" + val +
                ", freq=" + freq +
                '}';
    }

    pair(int val, int freq)
    {
        this.val = val;
        this.freq = freq;
    }

    @Override
    public int compareTo(pair o) {
        return 0;
    }
}

class Solution {
    public void topKFrequent(int[] nums, int k) {
        AtomicInteger  cnt = new AtomicInteger();
        cnt.incrementAndGet();
    }
}