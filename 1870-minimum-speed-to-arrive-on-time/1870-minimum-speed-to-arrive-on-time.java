class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left=1;
        int right=10000000;
        int ans=-1;
        while(left<=right){ 
            int mid=left+(right-left)/2;
            double time=0;
            for(int j=0;j<dist.length-1;j++){ 
                time+=Math.ceil((double)dist[j]/mid);
            }
            time+=(double)dist[dist.length-1]/mid;
            if(time>hour){ 
                left=mid+1;
             }
             else {  
                ans=mid;
                right=mid-1;
             }


        }

        return ans;
    }
}