import java.util.*;

class Solution {

    class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    int n;
    int[][] arr;
    State[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();

        arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0); // start
            arr[i][1] = intervals.get(i).get(1); // end
            arr[i][2] = intervals.get(i).get(2); // weight
            arr[i][3] = i;                       // original index
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        dp = new State[n + 1][5];

        State result = solve(0, 4);

        int[] ans = new int[result.indices.size()];

        for (int i = 0; i < result.indices.size(); i++) {
            ans[i] = result.indices.get(i);
        }

        return ans;
    }

    private State solve(int i, int remaining) {

        if (i == n || remaining == 0) {
            return new State(0, new ArrayList<>());
        }

        if (dp[i][remaining] != null) {
            return dp[i][remaining];
        }

        // Option 1: Skip current interval
        State skip = solve(i + 1, remaining);

        // Option 2: Take current interval
        int next = findNext(i);

        State nextState = solve(next, remaining - 1);

        List<Integer> takeIndices =
            new ArrayList<>(nextState.indices);

        takeIndices.add(arr[i][3]);

        Collections.sort(takeIndices);

        State take = new State(
            arr[i][2] + nextState.score,
            takeIndices
        );

        State best = better(take, skip);

        dp[i][remaining] = best;

        return best;
    }

    private int findNext(int i) {

        int target = arr[i][1];

        int low = i + 1;
        int high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid][0] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private State better(State a, State b) {

        if (a.score > b.score) {
            return a;
        }

        if (a.score < b.score) {
            return b;
        }

        return compare(a.indices, b.indices) < 0 ? a : b;
    }

    private int compare(List<Integer> a, List<Integer> b) {

        int size = Math.min(a.size(), b.size());

        for (int i = 0; i < size; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }
}