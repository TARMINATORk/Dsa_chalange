class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] arr=new int[nums.length];
        int n=nums.length;
        Stack<Integer>st=new Stack<>();
       
        for(int i=2*n-1;i>=0;i--){ 
            int curr=nums[i%n];
            while(!st.isEmpty() && st.peek()<= curr){ 
                st.pop();
            }
            if(i<n){
                if(st.isEmpty()){ 
                    arr[i]=-1;
                }
                else{ 
                    arr[i]=st.peek();
                }
               
            }
             st.push(curr);
        }
        return arr;
    }
}