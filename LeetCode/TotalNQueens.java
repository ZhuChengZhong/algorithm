package leetcode;

public class TotalNQueens {
    public int totalNQueens(int n) {
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i;
        }
        int res=solveNQueens(arr,0);
        return res;
    }
       private int solveNQueens(int[]arr,int index){
           if(index>0&&!check(arr,index-1)){
               return 0;
           }
        if(index==arr.length){
                return 1;
        }
           int res=0;
        for(int i=index;i<arr.length;i++){
            swap(arr,index,i);
           res+=solveNQueens(arr,index+1);
            swap(arr,index,i);
        }
           return res;
    }
    private void swap(int[]arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    private boolean check(int[] arr,int k){
        int n=arr.length;
        for(int i=0;i<k;i++){
            if(Math.abs(arr[k]-arr[i])==Math.abs(k-i)){
                  return false;
            }
        }
        return true;
    }
	    public static void main(String[] args) {
			int n=new TotalNQueens().totalNQueens(4);
			System.out.println(n);
		}
}
