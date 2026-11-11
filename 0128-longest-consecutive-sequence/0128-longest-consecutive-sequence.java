class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer>st=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            st.add(nums[i]);
        }
        int count=0;
        int logest=0;
        for(int num:st){

            int curr=0;
            if(!st.contains(num-1)){
                curr=num;
                count=1;
                while(st.contains(curr+1)){
                    curr++;
                    count++;
                }

                logest=Math.max(logest,count);
            }


        }
        return logest;
    }
}