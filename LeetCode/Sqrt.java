package leetcode;

public class Sqrt {
    public static int sqrt(int x) {
        int left=0,right=x;
        while(left<right){
            int mid=(left+right+1)>>1;
            int temp=x/mid;
            if(temp==mid){
                return mid;
            }else if(temp>mid){
                left=mid;
            }else if(temp<mid){
                right=mid-1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
		System.out.println(sqrt(3432));
	}
}
