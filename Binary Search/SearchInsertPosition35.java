class SearchInsertPosition35 {
    public static void main(String[] args) {
        int[] nums={1,3};
        System.out.println(searchInsert(nums,2));
    }
    public static int searchInsert(int[] nums, int target) {
        int start=0;
        int end= nums.length -1;
        if(target<=nums[0]){
            return 0;
        }
        while(start<=end){
            int mid = start+ (end-start)/2;
            if(nums[mid]>target){
                end=mid-1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }else{
                return mid;
            }
        }
      return start;
    }
}