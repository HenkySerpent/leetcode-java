public class FindSmallestLetterGreaterThanTarget744 {

    public static void main(String[] args) {
        char[] letters = {'a','b','d'};
           System.out.println( nextGreatestLetter(letters, 'c'));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int start=0;
        int end= letters.length -1;
        if(Character.compare(target,letters[end])>=0){
            return letters[0];
        }
        while(start<=end){
            int mid=start + ((end-start)/2);
            if(Character.compare(target,letters[mid])>=0){
                start = mid+1;
            }
            else if(Character.compare(target,letters[mid])<0){
                end = mid-1; 
            }
        }
        return letters[start];
    }
}
