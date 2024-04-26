/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */
interface MountainArray {

  public int get(int index);


  public int length() ;
}

public class SearchInMountainArray1095 {
  /**
   * // This is MountainArray's API interface.
   * // You should not implement it, or speculate about its implementation
   * interface MountainArray {
   * public int get(int index) {}
   * public int length() {}
   * }
   */

  public int findInMountainArray(int target, MountainArray mountainArr) {
    int start = 0;
    int peak = peakIndexInMountainArray(mountainArr);
    int ans = -1;
    if (mountainArr.get(peak) == target) {
      return peak;
    }
    ans = search(mountainArr, peak, target, true);
    if (ans == -1) {
      ans = search(mountainArr, peak + 1, target, false);
    }
    return ans;

  }

  public int peakIndexInMountainArray(MountainArray mountainArr) {
    int start = 0;
    int end = mountainArr.length() - 1;
    int ans = start;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      int midValue = mountainArr.get(mid);
      if (mid != 0 && midValue > mountainArr.get(mid + 1) &&
          midValue > mountainArr.get(mid - 1)) {
        return mid;
      }
      if (midValue > mountainArr.get(mid + 1)) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }

    }
    return ans;

  }

  public static int search(MountainArray mountainArr, int peak, int target, boolean asc) {
    int ans = -1;
    int start;
    int end;
    if (asc) {
      start = 0;
      end = peak;
    } else {
      start = peak;
      end = mountainArr.length() - 1;
    }
    while (start <= end) {
      int mid = start + ((end - start) / 2);
      int midValue = mountainArr.get(mid);

      if (midValue == target) {
        return mid;
      }
      if (asc) {
        if (midValue > target) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (midValue > target) {

          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return ans;

  }


}