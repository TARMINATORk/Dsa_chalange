class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char sign = '+';

        for (int i = 0; i <= s.length(); i++) {

            char ch = (i == s.length()) ? '+' : s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } 
            else if (ch != ' ') {

                if (sign == '+') {
                    st.push(num);
                } 
                else if (sign == '-') {
                    st.push(-num);
                } 
                else if (sign == '*') {
                    st.push(st.pop() * num);
                } 
                else if (sign == '/') {
                    st.push(st.pop() / num);
                }

                num = 0;
                sign = ch;
            }
        }

        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }
}