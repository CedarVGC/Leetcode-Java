package problem1_50;

public class Question13 {
    public int romanToInt(String s) {
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            switch (s.charAt(i)) {
                case 'I':
                    if(i+1<s.length()&&s.charAt(i+1)=='V'){
                        result+=4;
                        i++;
                    }
                    else if(i+1<s.length()&&s.charAt(i+1)=='X'){
                        result+=9;
                        i++;
                    }
                    else {
                        result+=1;
                    }
                    break;
                case 'V':
                    result+=5;
                    break;
                case 'X':
                    if(i+1<s.length()&&s.charAt(i+1)=='L'){
                        result+=40;
                        i++;
                    }
                    else if(i+1<s.length()&&s.charAt(i+1)=='C'){
                        result+=90;
                        i++;
                    }
                    else {
                        result+=10;
                    }
                    break;
                case 'L':
                    result+=50;
                    break;
                case 'C':
                    if(i+1<s.length()&&s.charAt(i+1)=='D'){
                        result+=400;
                        i++;
                    }
                    else if(i+1<s.length()&&s.charAt(i+1)=='M'){
                        result+=900;
                        i++;
                    }
                    else {
                        result+=100;
                    }
                    break;
                case 'D':
                    result+=500;
                    break;
                case 'M':
                    result+=1000;
                    break;
            }
        }
        return result;
    }
    /**/
    public int romanToInt2(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    public static void main(String[] args) {
        Question13 q=new Question13();
        String a="III",b="IV",c="IX",d="LVIII",e="MCMXCIV",f="DCXXI";
        System.out.println(q.romanToInt(a)+" "+q.romanToInt(b)+" "+q.romanToInt(c)+" "+q.romanToInt(d)+" "+q.romanToInt(e)+" "+q.romanToInt(f));
    }
}
