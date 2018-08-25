package leetcode;

public class MaxSubArray {
    public int maxSubArray(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int max=Integer.MIN_VALUE,sum=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            max=max>sum?max:sum;
            sum=sum<0?0:sum;
        }
        return max;
    }
}
