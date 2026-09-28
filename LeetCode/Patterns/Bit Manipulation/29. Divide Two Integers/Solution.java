class Solution {
    public int divide(int dividend, int divisor) {
        // observation case
        if(dividend == divisor) return 1;
        boolean sign = true;
        if(divisor > 0 && dividend < 0 || divisor<0 && dividend>0){
            sign = false;
        }
        
        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        long ans = 0;
        System.out.println(n + ":" + d);
        while(n >= d){
            int count = 0;
            while(n >=  (d << (count + 1))){
                count++;
            }
            ans += (1L << count);
            n = n - (d * (1L << count));
        }
        System.out.println(ans);
        // System.out.println(1 << 31);
        if(ans == (1L<<31) && sign) return Integer.MAX_VALUE;
        if(ans == (1L<<31) && !sign) return Integer.MIN_VALUE;
        return (sign)? (int)ans : (int)-ans;
    }
}
    
