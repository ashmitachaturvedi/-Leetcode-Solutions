
import java.util.*;

class Solution {

    static class MedianWindow {
        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();

        int lowSize = 0;
        int highSize = 0;

        long lowSum = 0;
        long highSum = 0;

        void addToLow(int x) {
            low.put(x, low.getOrDefault(x, 0) + 1);
            lowSize++;
            lowSum += x;
        }

        void addToHigh(int x) {
            high.put(x, high.getOrDefault(x, 0) + 1);
            highSize++;
            highSum += x;
        }

        void removeFromLow(int x) {
            int count = low.get(x);

            if (count == 1) {
                low.remove(x);
            } else {
                low.put(x, count - 1);
            }

            lowSize--;
            lowSum -= x;
        }

        void removeFromHigh(int x) {
            int count = high.get(x);

            if (count == 1) {
                high.remove(x);
            } else {
                high.put(x, count - 1);
            }

            highSize--;
            highSum -= x;
        }

        void add(int x) {
            if (lowSize == 0 || x <= low.lastKey()) {
                addToLow(x);
            } else {
                addToHigh(x);
            }

            rebalance();
        }

        void remove(int x) {
            if (low.containsKey(x)) {
                removeFromLow(x);
            } else {
                removeFromHigh(x);
            }

            rebalance();
        }

        void rebalance() {
            int target = (lowSize + highSize + 1) / 2;

            while (lowSize > target) {
                int x = low.lastKey();
                removeFromLow(x);
                addToHigh(x);
            }

            while (lowSize < target) {
                int x = high.firstKey();
                removeFromHigh(x);
                addToLow(x);
            }
        }

        long getCost() {
            long median = low.lastKey();

            long leftCost = median * lowSize - lowSum;
            long rightCost = highSum - median * highSize;

            return leftCost + rightCost;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Step 1: Calculate cost of every window
        long[] cost = new long[n - x + 1];

        MedianWindow window = new MedianWindow();

        for (int i = 0; i < n; i++) {

            window.add(nums[i]);

            if (i >= x) {
                window.remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = window.getCost();
            }
        }

        // Step 2: Dynamic Programming
        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        // Select exactly t non-overlapping windows
        for (int t = 1; t <= k; t++) {

            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                // Skip current position
                curr[i] = curr[i - 1];

                // Select window ending at i-1
                if (i >= x && prev[i - x] != INF) {

                    long take = prev[i - x] + cost[i - x];

                    curr[i] = Math.min(curr[i], take);
                }
            }

            prev = curr;
            curr = new long[n + 1];
        }

        return prev[n];
    }
}
