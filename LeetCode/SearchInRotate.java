package leetcode;

public class SearchInRotate {
	   public static boolean search(int[] A, int target) {
	        int left=0,right=A.length-1;
	        while(left<right){
	            int mid=(left+right)>>1;
	            if(A[mid]==target) return true;
	            if(A[mid]==A[left]){
	                left++;
	            }else if(A[mid]>A[left]){
	                if(target<A[mid]&&target>=A[left]){
	                    right=mid-1;
	                }else{
	                    left=mid+1;
	                }
	            }else{
	                if(target>A[mid]&&target<=A[right]){
	                    left=mid+1;
	                }else{
	                    right=mid-1;
	                }
	            }
	        }
	        return A[left]==target;
	    }
	   public static void main(String[] args) {
		   int[]arr={1,1,1,1,1,0,1,1};
		   System.out.println(search(arr, 0));
	   }
}
