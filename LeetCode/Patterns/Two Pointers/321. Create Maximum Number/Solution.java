class Solution {
    int[] ans;

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        ans = new int[k];

        for (int i = 0; i <= k; i++) {

            int j = k - i;

            if (i > nums1.length || j > nums2.length)
                continue;

            generate(nums1, 0, i, new int[i], 0,
                     nums2, 0, j, new int[j], 0);
        }

        return ans;
    }

    void generate(int[] a, int idx1, int len1, int[] x, int p1,
                  int[] b, int idx2, int len2, int[] y, int p2) {

        if (p1 == len1) {

            if (p2 == len2) {

                int[] curr = new int[len1 + len2];

                int i = 0, j = 0, t = 0;

                while (i < len1 || j < len2) {

                    if (j == len2) {
                        curr[t++] = x[i++];
                    }
                    else if (i == len1) {
                        curr[t++] = y[j++];
                    }
                    else if (x[i] > y[j]) {
                        curr[t++] = x[i++];
                    }
                    else if (x[i] < y[j]) {
                        curr[t++] = y[j++];
                    }
                    else {
                        int p = i;
                        int q = j;

                        while (p < len1 && q < len2 &&
                               x[p] == y[q]) {
                            p++;
                            q++;
                        }

                        if (q == len2 ||
                            (p < len1 && x[p] > y[q])) {
                            curr[t++] = x[i++];
                        }
                        else {
                            curr[t++] = y[j++];
                        }
                    }
                }

                for (int z = 0; z < len1 + len2; z++) {

                    if (curr[z] > ans[z]) {
                        ans = curr;
                        break;
                    }

                    if (curr[z] < ans[z]) {
                        break;
                    }
                }

                return;
            }

            for (int i = idx2; i < b.length; i++) {

                y[p2] = b[i];

                generate(a, idx1, len1, x, p1,
                         b, i + 1, len2, y, p2 + 1);
            }

            return;
        }

        for (int i = idx1; i < a.length; i++) {

            x[p1] = a[i];

            generate(a, i + 1, len1, x, p1 + 1,
                     b, idx2, len2, y, p2);
        }
    }
}