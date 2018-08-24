package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations2 {
	  public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
	        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
	        Arrays.sort(num);
	       // permutation(res,num,0);
	        ArrayList<Integer>list=new ArrayList<>();
	        boolean[]used=new boolean[num.length];
	        permutation2(used, res, list, num);
	        return res;
	    }
	  private void permutation2(boolean[]used,ArrayList<ArrayList<Integer>>res,ArrayList<Integer>list,int[]num){
		  if(list.size()==num.length){
			  res.add(new ArrayList<>(list));
			  return ;
		  }
		  for(int i=0;i<num.length;i++){
			  if(used[i]) continue;
			  if(i!=0&&num[i]==num[i-1]&&!used[i-1]) continue;
			  used[i]=true;
			  list.add(num[i]);
			  permutation2(used, res, list, num);
			  list.remove(list.size()-1);
			  used[i]=false;
		  }
	  }
	    private void permutation(ArrayList<ArrayList<Integer>>res,int[]num,int index){
	        if(index==num.length){
	            ArrayList<Integer>list=new ArrayList<>();
	            for(int i=0;i<num.length;i++){
	                list.add(num[i]);
	            }
	            res.add(list);
	        }
	        for(int i=index;i<num.length;i++){
	            if(i!=index&&num[i]==num[index]){
	                continue;
	            }
	            swap(num,index,i);
	            permutation(res,num,index+1);
	            swap(num,index,i);
	        }
	    }
	    private void swap(int[]arr,int i,int j){
	        int t=arr[i];
	        arr[i]=arr[j];
	        arr[j]=t;
	    }
	    public static void main(String[] args) {
	    	int[]num={1,1,2};
			System.out.println(new Permutations2().permuteUnique(num));
		}
}
