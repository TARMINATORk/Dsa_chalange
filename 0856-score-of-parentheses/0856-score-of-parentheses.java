class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer>st=new Stack<>();
        int score=0;
        for(char ch:s.toCharArray()) { 
            if(ch=='(') { 
                st.push(score);
                score=0;
            }
            else { 
                int previous=st.pop();
                score=previous+Math.max(2*score,1);
            }
        }
        return score;
    }
}