import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        // Find minimum number of '(' and ')' to remove
        int left = 0;
        int right = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                left++;
            } 
            else if (ch == ')') {

                if (left > 0) {
                    left--;
                } 
                else {
                    right++;
                }
            }
        }

        // left = extra '('
        // right = extra ')'

        backtrack(s, 0, left, right, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(
            String s,
            int index,
            int leftRemove,
            int rightRemove,
            int balance,
            StringBuilder current,
            List<String> result) {

        // Invalid balance
        if (balance < 0) {
            return;
        }

        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {

                result.add(current.toString());
            }

            return;
        }

        char ch = s.charAt(index);

        // Option 1: Remove current parenthesis
        if (ch == '(' && leftRemove > 0) {

            // Avoid duplicate results
            if (index == 0 || s.charAt(index - 1) != '(') {
                backtrack(
                    s,
                    index + 1,
                    leftRemove - 1,
                    rightRemove,
                    balance,
                    current,
                    result
                );
            }
        }

        if (ch == ')' && rightRemove > 0) {

            // Avoid duplicate results
            if (index == 0 || s.charAt(index - 1) != ')') {
                backtrack(
                    s,
                    index + 1,
                    leftRemove,
                    rightRemove - 1,
                    balance,
                    current,
                    result
                );
            }
        }

        // Option 2: Keep current character
        current.append(ch);

        if (ch == '(') {
            backtrack(
                s,
                index + 1,
                leftRemove,
                rightRemove,
                balance + 1,
                current,
                result
            );
        } 
        else if (ch == ')') {

            if (balance > 0) {
                backtrack(
                    s,
                    index + 1,
                    leftRemove,
                    rightRemove,
                    balance - 1,
                    current,
                    result
                );
            }

        } 
        else {
            // Normal character
            backtrack(
                s,
                index + 1,
                leftRemove,
                rightRemove,
                balance,
                current,
                result
            );
        }

        current.deleteCharAt(current.length() - 1);
    }
}