package leetcode;

public class FirstMissingPositive {
	   public static int firstMissingPositive(int[] A) {
	        if(A==null||A.length==0){
	            return 1;
	        }
	        for(int i=0;i<A.length;i++){
	            while(A[i]!=i+1&&A[i]-1>=0&&A[i]-1<A.length&&A[i]!=A[A[i]-1]){
	                swap(A,A[i]-1,i);
	            }
	        }
	        for(int i=0;i<A.length;i++){
	            if(A[i]!=i+1){
	                return i+1;
	            }
	        }
	        return A.length+1;
	    }
	    private static void swap(int[]arr,int i,int j){
	        int t=arr[i];
	        arr[i]=arr[j];
	        arr[j]=t;
	    }
	    public static void main(String[] args) {
	    	int[]A={1};
			System.out.println(firstMissingPositive(A));
		}
}
