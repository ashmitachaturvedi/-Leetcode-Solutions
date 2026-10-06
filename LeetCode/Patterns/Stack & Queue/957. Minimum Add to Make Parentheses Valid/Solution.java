
class SOlution{
    public int minAddToMakeValid(String s){
        Stack<Character> st = new Stack<>();
        int add = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(ch);
            }
            else{
                if(!st.isEmpty()){
                    st.pop();
                }
                else{
                    add++;
                }
            }
        }
        return add + st.size();
    }
}