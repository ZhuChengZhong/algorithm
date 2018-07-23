package leetcode;
/**
 *  Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A =[1,1,2],

Your function should return length =2, and A is now[1,2]. 
 * @author Administrator
 *
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int left=0;
        for(int i=1;i<A.length;i++){
            if(A[i]!=A[left]){
                A[++left]=A[i];
            }
        }
        return left+1;
    }
}
