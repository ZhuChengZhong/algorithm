package leetcode;

public class RemoveDuplicates2 {
    public int removeDuplicates(int[] A) {
        if(A==null) return 0;
        if(A.length<2) return A.length;
        int index=0;
        for(int i=1;i<A.length;i++){
            if(index>=1&&A[i]==A[index]&&A[i]==A[index-1]){
                continue;
            }
            A[++index]=A[i];
        }
        return ++index;
    }
}
