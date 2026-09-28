class Solution {
    public int maxDepth(String s) {
       int n = s.length();
       int count = 0;
       int maxCount = 0;
       for(int i = 0 ; i < n ; i++){
        if(s.charAt(i) == '('){
            count++;
            maxCount = Math.max(count,maxCount);
        }        
        else if(s.charAt(i) == ')') count--;
       } 
       return maxCount;
    }
}