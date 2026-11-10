class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer>mpp=new HashMap<>();
        mpp.put(0,1);
        int c=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(mpp.containsKey(sum-k)){
                c+=mpp.get(sum-k);
            }
            mpp.put(sum,mpp.getOrDefault(sum,0)+1);
        }
        return c;
    }
}