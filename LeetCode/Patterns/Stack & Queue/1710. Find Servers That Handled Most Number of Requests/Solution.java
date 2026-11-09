
import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> available = new TreeSet<>();

        // {finishing time, server index}
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        int[] count = new int[k];

        // Initially all servers are available
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {

            // Release servers whose tasks are completed
            while (!busy.isEmpty() &&
                   busy.peek()[0] <= arrival[i]) {

                long[] server = busy.poll();
                available.add((int) server[1]);
            }

            // If all servers are busy, drop request
            if (available.isEmpty()) {
                continue;
            }

            // Preferred server
            int preferred = i % k;

            // Find next available server
            Integer server = available.ceiling(preferred);

            // Circular search
            if (server == null) {
                server = available.first();
            }

            // Assign request
            available.remove(server);

            count[server]++;

            // Mark server as busy
            long finishTime = (long) arrival[i] + load[i];

            busy.offer(new long[]{finishTime, server});
        }

        // Find maximum requests handled
        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        // Collect busiest servers
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}
