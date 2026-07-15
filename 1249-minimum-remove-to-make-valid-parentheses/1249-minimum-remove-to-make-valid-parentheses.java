class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer>st=new Stack<>();
        char[] arr=s.toCharArray();

        for(int i=0;i<s.length();i++) {

            char ch=s.charAt(i); 
            if(ch=='(') { 
                st.push(i);
            }
            else if(ch==')') { 
                if(!st.isEmpty()) { 
                    st.pop();
                }
                else { 
                    arr[i]='*';
                }
            }
        }
        while(!st.isEmpty()) { 
            arr[st.pop()]='*';
        }
        StringBuilder sb=new StringBuilder();
        for(char ch: arr) { 
            if(ch!='*') { 
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}