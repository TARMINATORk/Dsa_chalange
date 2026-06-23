class Solution {
    public int maxDepth(String s) {
        int count=0;
        int maxi=0;
        for(char ch:s.toCharArray()) {  

            if(ch=='('){  
                count ++;
                maxi=Math.max(maxi,count);
            }
            else if(ch==')'){  
                count--;
            }
        }
        return maxi;
    }
}