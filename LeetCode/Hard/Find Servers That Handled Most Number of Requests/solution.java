import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) available.add(i);

        // {endTime, serverId}; endTime can reach ~2e9, so use long
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            long start = arrival[i];

            // Release servers that have finished by now
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.add((int) busy.poll()[1]);
            }

            if (available.isEmpty()) continue; // request dropped

            // First free server at or after i % k, wrapping around
            Integer s = available.ceiling(i % k);
            if (s == null) s = available.first();

            available.remove(s);
            count[s]++;
            busy.offer(new long[]{start + load[i], s});
        }

        int best = 0;
        for (int c : count) best = Math.max(best, c);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == best) res.add(i);
        }
        return res;
    }
}