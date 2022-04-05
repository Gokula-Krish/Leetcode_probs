class Solution {
public:
    int maxArea(vector<int>& height) {
        int l=0,r=height.size()-1;int mx=0;
        while(l<r){
            int a,b,len;
            len=r-l;
            b=height[l]<height[r]?height[l]:height[r];
            a=len*b;
            mx=max(mx,a);
            height[l]>height[r]?r--:l++;
        }return mx;
    }
};