class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(count);
                count = 0;
            }
            else{
                count = st.pop() + Math.max(2*count,1);
            }
        }
        return count;
    }
}