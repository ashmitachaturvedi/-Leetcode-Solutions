
import java.util.Arrays;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] result = new int[n][3];

        // [digit sum, number, original index]
        for (int i = 0; i < n; i++) {
            int number = nums[i];
            int sum = 0;

            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }

            result[i][0] = sum;
            result[i][1] = nums[i];
            result[i][2] = i;
        }

        // Sort by digit sum, then by number
        Arrays.sort(result, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Original index -> sorted position
        int[] dest = new int[n];

        for (int i = 0; i < n; i++) {
            dest[result[i][2]] = i;
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || dest[i] == i) {
                continue;
            }

            int cycle = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = dest[j];
                cycle++;
            }

            swaps += cycle - 1;
        }

        return swaps;
    }
}
