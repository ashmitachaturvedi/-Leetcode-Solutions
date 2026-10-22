class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean sorted = true;
        for(int i = 1 ; i < n ; i++){
            if(s.charAt(i) < s.charAt(i - 1)){
                sorted = false;
                break;
            }
        }
        if(sorted) return 0;
        if(n == 2) return -1;
        char minChar = 'z';
        char maxChar = 'a';
        for(int i = 0 ; i < n ; i++){
            minChar = (char) Math.min(minChar, s.charAt(i));
            maxChar = (char) Math.max(maxChar, s.charAt(i));
        }
        if(s.charAt(0)  == minChar || s.charAt(n - 1) == maxChar){
            return 1;
        }
        if(s.charAt(0) == maxChar && s.charAt(n - 1) == minChar) return 3;
        return 2;

    }
}
