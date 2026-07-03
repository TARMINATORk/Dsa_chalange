class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxi=0;
        long sum=0;
        int left=0;
        HashMap<Integer,Integer>mpp=new HashMap<>();

        for(int right=0;right<nums.length;right++) {  
            sum+=nums[right];
            mpp.put(nums[right],mpp.getOrDefault(nums[right],0)+1);

            if(right-left+1>k){  
                sum-=nums[left];
                mpp.put(nums[left],mpp.getOrDefault(nums[left],0)-1);
                if(mpp.get(nums[left])==0){  
                    mpp.remove(nums[left]);
                }
                left++;
            }

            if(right-left+1==k){ 
                if(mpp.size()==k){  
                    maxi=Math.max(maxi,sum);
                } 
            }
        }
        return maxi;

    }
}