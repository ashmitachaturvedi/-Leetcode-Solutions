import java.util.*;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int[] best = new int[n + 1];
        Arrays.fill(best, Integer.MAX_VALUE);

        best[0] = Integer.MAX_VALUE;

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int length = right - left + 1;

                if (best[left] != Integer.MAX_VALUE) {
                    answer = Math.min(
                        answer,
                        best[left] + length
                    );
                }

                minLength = Math.min(minLength, length);
            }

            best[right + 1] = minLength;
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}