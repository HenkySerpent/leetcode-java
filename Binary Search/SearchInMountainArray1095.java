import java.util.Arrays;
import java.util.List;

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */
 public class SearchInMountainArray1095 {
    public static void main(String[] args) {
        List<Integer>   mountainArr = Arrays.asList(1,2,3,5,7,4);
        System.out.println(findInMountainArray(4, mountainArr));
        
    }

    public static  int findInMountainArray(int target, List<Integer> mountainArr) {
        int peak = peakIndexInMountainArray(mountainArr);
        int ans = -1;
        if(mountainArr.get(peak) == target){
            return peak;
        }
        ans = search(mountainArr, peak, target, true);
        if (ans == -1) {
            search(mountainArr, peak, target, false);
        }
        return ans;

    }

    public static int peakIndexInMountainArray(List<Integer> mountainArr) {
        int start = 0;
        int end = mountainArr.size() - 1;
        int ans = start;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid != 0 && mountainArr.get(mid) > mountainArr.get(mid + 1) &&
                    mountainArr.get(mid) > mountainArr.get(mid - 1)) {
                return mid;
            }
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return ans;

    }

    public static int search(List<Integer> mountainArr, int peak, int target, boolean asc) {
        int ans = -1;
        int start;
        int end;
        if (asc) {
            start = 0;
            end = peak;
        } else {
            start = peak;
            end = mountainArr.size() - 1;
        }
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (mountainArr.get(mid) > target) {
                if (asc) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (mountainArr.get(mid) < target) {
                if (asc) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                return mid;
            }
        }
        return ans;
    }
}