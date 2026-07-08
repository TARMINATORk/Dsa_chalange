class Solution {
    public int calculate(String s) {
        int num = 0;
        int result=0;
        int last=0;
        char sign = '+';

        for (int i = 0; i <= s.length(); i++) {

            char ch = (i == s.length()) ? '+' : s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } 
            else if (ch != ' ') {

                if (sign == '+') {
                    result+=last;
                    last=num;
                } 
                else if (sign == '-') {
                   result+=last;
                   last=-num;
                } 
                else if (sign == '*') {
                   last=last*num;
                } 
                else if (sign == '/') {
                    last=last/num;
                }

                num = 0;
                sign = ch;
            }
        }

       

        return result+last;
    }
}