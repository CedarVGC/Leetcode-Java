package problem1_50;
public class Question7 {
    public int reverse(int x) {
        int sign=x>=0?1:-1;
        char[] e=String.valueOf(Math.abs(x)).toCharArray();
        long result=0;
        for(int i=e.length-1;i>=0;i--) {
            result+=(e[i]-'0')*Math.pow(10,i);
        }
        result=sign*result;
        return result<Integer.MAX_VALUE&&result>Integer.MIN_VALUE?(int)result:0;
    }
    /*2的31次方是2147483648，最小值负2的31次方减一是-2147483647*/
    /*重点是判断rev*10+pop是否溢出*/
    int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
    public static void main(String[] args) {
        Question7 q=new Question7();
        int a=123,b=-123,c=120;
       System.out.println(q.reverse(a)+" "+q.reverse(b)+" "+q.reverse(c));
    }
}
