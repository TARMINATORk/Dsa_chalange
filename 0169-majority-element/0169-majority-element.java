class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int c=0;
        int out=0;
        for(int i=0;i<n;i++){
            if(c==0){
                c=1;
                out=nums[i];
            }
            else if(out==nums[i]){
                c++;
            }
            else{
                c--;
            }
        }
        return out;
    }
}