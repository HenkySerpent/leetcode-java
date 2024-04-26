class SQRT69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
    public static int mySqrt(int x) {
        if(x==0 || x==1){
            return x;
        }
        int start=1;
        int end= x;
        while(start<=end){
            int mid=start+(end-start)/2;
            long temp=(long) mid*mid;
            if(temp == x){
                return mid;
            }else if(temp> (long) x){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return Math.round(end);
    }
}