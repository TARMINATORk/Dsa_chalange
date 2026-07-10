class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int [] height=new int[col];
        int maxArea=0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++){ 
                if(matrix[i][j]=='1'){ 
                    height[j]++;
                }
                else { 
                    height[j]=0;
                }
            }
            maxArea=Math.max(maxArea,largestHistogram(height));
         }
         return maxArea;

    }


    public int largestHistogram(int[] heights) {
        Deque<Integer>st=new ArrayDeque<>();
        int n=heights.length;
        int maxarea=0;

        for(int i=0;i<=n;i++) { 
            int h;
            if(i==n){ 
                h=0;
            }
            else{ 
                h=heights[i];
            }
            while(!st.isEmpty() && h<heights[st.peek()]){ 
                int height=heights[st.pop()];
                int width;
                if(st.isEmpty()){ 
                    width=i;

                }
                else{ 
                    width=i-st.peek()-1;
                }
                int area=height*width;
                maxarea=Math.max(maxarea,area);
            }
            st.push(i);
        }
        return maxarea;
    }
}