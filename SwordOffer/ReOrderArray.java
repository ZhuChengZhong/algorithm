/*package com.zhu.practice;

public class ReOrderArray {
	 public static void reOrderArray(int [] array) {
		 if(array==null||array.length==0){
			 return ;
		 }
	      int left=0,right=array.length-1;
	      while(left<right){
	    	  while((left&1)==1)
	    		  left++;
	    	  while((right&1)==0)
	    		  right--;
	    	  if(left<right){
	    		  int temp=array[left];
	    		  array[left]=array[right];
	    		  array[right]=array[left];
	    		  left++;
	    		  right--;
	    	  }
	      }
	 }
	 public static void main(String[] args) {
		int[] array={1,2,3,4,5,6,7};
		reOrderArray(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
	}
}
*/