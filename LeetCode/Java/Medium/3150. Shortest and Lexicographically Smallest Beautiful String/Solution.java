class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int first = -1;
        int count = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
                if (count == 1) {
                    first = i;
                }
                if (count == k) {
                    int len = i - first + 1;
                    String curr = s.substring(first, i + 1);
                    if (ans.equals("") ||
                        len < ans.length() ||
                        (len == ans.length() && curr.compareTo(ans) < 0)) {
                        ans = curr;
                    }
                    count--;
                    first = s.indexOf('1', first + 1);
                }
            }
        }
        return ans;
    }
}