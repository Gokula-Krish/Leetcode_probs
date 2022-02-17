/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findPeak(MountainArray arr){
        int l=0,r=arr.length()-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(arr.get(mid)>arr.get(mid+1)){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int pIndex=findPeak(mountainArr);
        if(mountainArr.get(pIndex)==target){
            return pIndex;
        }
        int s=search(mountainArr,0,pIndex,target,false);
        if(s==-1){
            return search(mountainArr,pIndex+1,mountainArr.length()-1,target,true);
        }
        return s;
    }
    public int search(MountainArray mountainArr,int l,int r,int target,boolean moun){
        while(l<=r){
            int mid=l+(r-l)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }
            if(moun){
                if(mountainArr.get(mid)<target){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            if(!moun){
                if(mountainArr.get(mid)>target){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
        }
        return -1;
    }
}