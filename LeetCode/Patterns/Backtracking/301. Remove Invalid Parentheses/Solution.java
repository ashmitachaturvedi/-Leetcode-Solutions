import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        remove(s, result, 0, 0, new char[]{'(', ')'});

        return result;
    }

    private void remove(
        String s,
        List<String> result,
        int start,
        int lastRemove,
        char[] par
    ) {

        int balance = 0;

        for (int i = start; i < s.length(); i++) {

            if (s.charAt(i) == par[0]) {
                balance++;
            }

            if (s.charAt(i) == par[1]) {
                balance--;
            }

            // Extra closing bracket found
            if (balance < 0) {

                for (int j = lastRemove; j <= i; j++) {

                    if (s.charAt(j) == par[1] &&
                        (j == lastRemove ||
                         s.charAt(j - 1) != par[1])) {

                        remove(
                            s.substring(0, j) + s.substring(j + 1),
                            result,
                            i,
                            j,
                            par
                        );
                    }
                }

                return;
            }
        }

        // No extra ')' left.
        // Now reverse and check extra '('.
        String reversed = new StringBuilder(s)
                                .reverse()
                                .toString();

        if (par[0] == '(') {

            remove(
                reversed,
                result,
                0,
                0,
                new char[]{')', '('}
            );

        } else {

            result.add(reversed);
        }
    }
}