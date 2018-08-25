package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class SolveNQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]>res=new ArrayList<>();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i;
        }
        solveNQueens(arr,res,0);
        return res;
    }
    private void solveNQueens(int[]arr,ArrayList<String[]>res,int index){
        if(index==arr.length){
            if(check(arr)){
                res.add(getMap(arr));
            }
            return ;
        }
        for(int i=index;i<arr.length;i++){
            swap(arr,index,i);
            solveNQueens(arr,res,index+1);
            swap(arr,index,i);
        }
    }
    private void swap(int[]arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    private String[] getMap(int[] arr){
        int n=arr.length;
        String[]res=new String[n];
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                if(arr[i]==j){
                    sb.append('Q');
                }else{
                    sb.append('.');
                }
            }
            res[i]=sb.toString();
        }
        return res;
    }
    private boolean check(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(Math.abs(arr[j]-arr[i])==Math.abs(j-i)){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
    	ArrayList<String[]>list=new SolveNQueens().solveNQueens(5);
    	for(String[]arr:list){
    		System.out.println(Arrays.toString(arr));
    	}
    	System.out.println((int)'.');
	}
}
