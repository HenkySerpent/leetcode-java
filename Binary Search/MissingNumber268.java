import java.util.Arrays;

public class MissingNumber268 {
  public static void main(String[] args) {
    int[] nums={3,0,1};
    System.out.println(missingNumber(nums));
  }
    public static int missingNumber(int[] nums) {
      int n = nums.length;
      int[] v = new int[n+1];
      Arrays.fill(v, -1);
      for(int i = 0; i < nums.length; i++) {
        v[nums[i]] = nums[i];
      }
      for(int i = 0; i < v.length; i++) {
        if(v[i] == -1) return i;
      }
      return 0;
    }

}
