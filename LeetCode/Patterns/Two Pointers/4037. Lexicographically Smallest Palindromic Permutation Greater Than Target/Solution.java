class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        int odd = 0;
        char mid = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }
        if (odd > 1)
            return "";
        int[] halfFreq = new int[26];
        for (int i = 0; i < 26; i++)
            halfFreq[i] = freq[i] / 2;
        int m = n / 2;
        char[] half = new char[m];
        if (!build(half, 0, halfFreq, target, mid, n))
            return "";
        StringBuilder ans = new StringBuilder();
        for (char c : half)
            ans.append(c);
        if (n % 2 == 1)
            ans.append(mid);
        for (int i = m - 1; i >= 0; i--)
            ans.append(half[i]);
        return ans.toString();
    }
    private boolean build(char[] half, int pos, int[] freq,String target, char mid, int n) {
        int m = half.length;
        if (pos == m) {
            StringBuilder x = new StringBuilder();
            for (char c : half)
                x.append(c);
            if (n % 2 == 1)
                x.append(mid);
            for (int i = m - 1; i >= 0; i--)
                x.append(half[i]);
            return x.toString().compareTo(target) > 0;
        }
        int t = target.charAt(pos) - 'a';
        for (int c = 0; c < 26; c++) {
            if (freq[c] == 0)
                continue;
            half[pos] = (char) ('a' + c);
            freq[c]--;
            if (c > t) {
                int k = pos + 1;
                for (int j = 0; j < 26; j++) {
                    while (freq[j] > 0) {
                        half[k++] = (char) ('a' + j);
                        freq[j]--;
                    }
                }
                return true;
            }
            if (c == t && build(half, pos + 1, freq, target, mid, n))
                return true;
            freq[c]++;
        }
        return false;
    }
}