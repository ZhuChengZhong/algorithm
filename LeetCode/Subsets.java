package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	   public ArrayList<ArrayList<Integer>> subsets(int[] S) {
	        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
	        ArrayList<Integer>list=new ArrayList<>();
	        Arrays.sort(S);
	        for(int i=0;i<=S.length;i++){
	            subsets(res,list,i,0,S);
	        }
	        return res;
	    }
	    private void subsets(ArrayList<ArrayList<Integer>>res,
	                        ArrayList<Integer>list,int k,int index,
	                        int[]arr){
	        if(k==0){
	            res.add(new ArrayList(list));
	            return ;
	        }
	        for(int i=index;i<arr.length;i++){
	            list.add(arr[i]);
	            subsets(res,list,k-1,i+1,arr);
	            list.remove(list.size()-1);
	        }
	    }
}
