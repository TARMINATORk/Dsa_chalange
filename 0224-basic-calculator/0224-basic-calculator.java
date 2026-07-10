class Solution {
    public int calculate(String s) {
        Stack<Integer>st=new Stack<>();
        int result=0;
        int num=0;
        int sign=1;

        for(char ch:s.toCharArray()) { 
            if(Character.isDigit(ch)){ 
                num=num*10+(ch-'0');
            }
            else if(ch=='+'){ 
                result+=sign*num;
                num=0;
                sign=1;
            }
            else if(ch=='-'){ 
                result+=sign*num;
                num=0;
                sign=-1;
            }
            else if(ch=='('){ 
                st.push(result);
                st.push(sign);
                result=0;
                sign=1;
            }
            else if(ch==')'){ 
                result+=sign*num;
                num=0;
                result*=st.pop();
                result+=st.pop();
            }
        }
        return result+sign*num;
    }
}