public class PeakIndexInMountainArray852{
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int start=0;
            int end=arr.length-1;
            int ans=start;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(mid!=0 && arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                    return mid;
                }
                if(arr[mid]>arr[mid+1]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
    
            }
            return ans;
    
        }
    }
}