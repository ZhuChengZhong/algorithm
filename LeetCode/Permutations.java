package leetcode;

import java.util.ArrayList;

public class Permutations {
	   public ArrayList<ArrayList<Integer>> permute(int[] num) {
	        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
	        permutation(res,num,0);
	        return res;
	    }
	    private void permutation(ArrayList<ArrayList<Integer>>res,int[] num,int index){
	        if(index==num.length){
	            ArrayList<Integer>list=new ArrayList<>();
	            for(int i=0;i<num.length;i++){
	                list.add(num[i]);
	            }
	            res.add(list);
	        }
	        for(int i=index;i<num.length;i++){
	            swap(num,index,i);
	            permutation(res,num,index+1);
	            swap(num,index,i);
	        }
	    }
	    private void swap(int[]num,int i,int j){
	        int t=num[i];
	        num[i]=num[j];
	        num[j]=t;
	    }
}
