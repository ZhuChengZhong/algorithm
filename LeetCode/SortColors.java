package leetcode;

public class SortColors {
    public void sortColors(int[] A) {
        int left=0,right=A.length-1;
        int index=0;
        while(index<=right){
            if(A[index]==0) swap(A,left++,index++);
            else if(A[index]==2) swap(A,right--,index);
            else index++;
        }
    }
    private void swap(int[]arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}
