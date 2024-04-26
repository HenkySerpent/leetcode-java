public class SearchInRotatedSortedArray33 {
  public static void main(String[] args) {
    int[] arr={3,5,2,1};
    search(arr,1);
  }

  public static int search(int[] arr, int target) {
    int pivot = findPivot(arr);
    int ans = -1;
    if (arr[pivot] == target) {
      return pivot;
    } else if (arr[0] > target) {
      return binarySearch(arr, pivot + 1, arr.length - 1, target);
    } else {
      return binarySearch(arr, 0, pivot - 1, target);
    }

  }

  private static int findPivot(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] > arr[mid + 1]) {
        return mid;
      } else if (arr[mid] > start) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  public static int binarySearch(int[] arr, int start, int end, int target) {
    int ans = -1;

    while (start <= end) {
      int mid = start + ((end - start) / 2);
      if (arr[mid] > target) {
        end = mid - 1;
      } else if (arr[mid] < target) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    return ans;
  }

}
