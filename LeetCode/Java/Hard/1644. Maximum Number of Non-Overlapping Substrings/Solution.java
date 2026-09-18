import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';

            if (first[ch] == -1) {
                first[ch] = i;
            }

            last[ch] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int ch = 0; ch < 26; ch++) {
            if (first[ch] == -1) {
                continue;
            }

            int start = first[ch];
            int end = last[ch];

            boolean valid = true;

            for (int i = start; i <= end; i++) {
                int curr = s.charAt(i) - 'a';

                if (first[curr] < start) {
                    valid = false;
                    break;
                }

                end = Math.max(end, last[curr]);
            }

            if (valid) {
                intervals.add(new int[]{start, end});
            }
        }

        intervals.sort((a, b) -> a[1] - b[1]);

        List<String> ans = new ArrayList<>();
        int prevEnd = -1;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start > prevEnd) {
                ans.add(s.substring(start, end + 1));
                prevEnd = end;
            }
        }

        return ans;
    }
}