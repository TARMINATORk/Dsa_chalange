class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0;
        int right=0;
        int ans=0;
        for(int w:weights) { 
            left=Math.max(left,w);
            right+=w;
        }
        while(left<=right){ 
            int mid=left+(right-left)/2;
            int day=1;
            int curr=0;

            for(int w:weights){ 
                if(curr+w <= mid){ 
                    
                    curr+=w;
                }
                else{ 
                    day++;
                    curr=w;
                }
            }
            if(day<=days){ 
                ans=mid;
                right=mid-1;
            }
            else { 
                left=mid+1;
            }
        }

        return ans;
    }
}