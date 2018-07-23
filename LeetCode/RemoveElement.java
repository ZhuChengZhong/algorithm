package leetcode;
/**
 *  Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.


 * @author Administrator
 *
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if(A==null||A.length==0){
            return 0;
        }
        int n=A.length;
        for(int i=0;i<n;i++){
            while(A[i]==elem&&i<n){
                A[i]=A[--n];
            }
        }
        return n;
    }
}
