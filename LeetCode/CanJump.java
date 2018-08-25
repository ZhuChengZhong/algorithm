package leetcode;

public class CanJump {
    public boolean canJump(int[] A) {
        if(A==null||A.length<=1){
            return true;
        }
        int max=0;
        for(int i=0;i<A.length-1;i++){
            max=max>A[i]+i?max:A[i]+i;
            if(max<=i){
                return false;
            }
        }
        return true;
    }
}
