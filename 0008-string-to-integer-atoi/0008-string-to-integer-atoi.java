class Solution {
    public int myAtoi(String s) {

        int i = 0;
        long res = 0;
        int sign = 1;

        // Skip spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Sign
        if (i < s.length() &&
            (s.charAt(i) == '+' || s.charAt(i) == '-')) {

            if (s.charAt(i) == '-') {
                sign = -1;
            }

            i++;
        }

        // Digits
        while (i < s.length() &&
               Character.isDigit(s.charAt(i))) {

            res = res * 10 + (s.charAt(i) - '0');

            if (sign == 1 && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign == -1 && -res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int)(sign * res);
    }
}