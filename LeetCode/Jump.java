package leetcode;

public class Jump {
    public int jump(int[] A) {
        if(A==null||A.length<=1){
            return 0;
        }
        int count=0,index=0,max=0;
        for(int i=0;i<A.length-1;i++){
            max=max>A[i]+i?max:A[i]+i;
            if(i==index){
                count++;
                index=max;
            }
        }
        return count;
    }
}
