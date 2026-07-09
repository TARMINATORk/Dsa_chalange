class Solution {
    public String decodeString(String s) {
        Stack<Integer>str=new Stack<>();
        Stack<StringBuilder>character=new Stack<>();
        int num=0;
        StringBuilder curr=new StringBuilder();
        for(char ch:s.toCharArray()) { 

            if(Character.isDigit(ch)){ 
                num=num * 10 +(ch-'0');
            }
            else if(Character.isLetter(ch)){ 
                curr.append(ch);
            }
            else if(ch=='['){ 
                str.push(num);
                character.push(curr);
                num=0;
                curr=new StringBuilder();
            }
            else{ 
                int repeat=str.pop();
                StringBuilder previous=character.pop();
                for(int i=0;i<repeat;i++){ 
                    previous.append(curr);
                }
                curr=previous;
            }
           
        }
        return curr.toString();
    }
}