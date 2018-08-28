package leetcode;

public class MergeTwoSortArray {
    public void merge(int A[], int m, int B[], int n) {
        int index=m+n-1;
        m-=1;
        n-=1;
        while(m>=0&&n>=0){
            if(A[m]>B[n]) A[index--]=A[m--];
            else A[index--]=B[n--];
        }
        while(m>=0) A[index--]=A[m--];
        while(n>=0) A[index--]=B[n--];
    }
}
