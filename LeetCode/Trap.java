package leetcode;

public class Trap {
    public int trap(int[] A) {
        if(A==null||A.length<=2){
            return 0;
        }
        int[]max=new int[A.length];
        int m=0;
        for(int i=1;i<A.length;i++){
            m=A[i-1]>m?A[i-1]:m;
            max[i]=m;
        }
        m=0;
        int res=0;
        int min;
        for(int i=A.length-2;i>=1;i--){
            m=A[i+1]>m?A[i+1]:m;
            min=max[i]<m?max[i]:m;
            if(min>A[i])
                res+=min-A[i];
        }
        return res;
    }
}
