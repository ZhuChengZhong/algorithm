package com.algorithm.offer;
/**
 * 统计一个数字在排序数组中出现的次数
 * @author Zhu
 * 思路：两次二分查找，一次找最左边的下标left 一次找最右边的下标right，出现次数=right-left+1;
 */
public class GetNumberOfK {
	public static int GetNumberOfK(int [] array , int k) {
		int count;
		if(array==null||array.length==0)
			count=0;
		int left,right;
	    if((left=getIndexOfFirstK(array, k))==-1||(right=getIndexOfLastK(array, k))==-1) { 
	    	count=0;
	    }
	    else
	    	count=right-left+1;
	    return count;
    }
	private static int getIndexOfFirstK(int [] array , int k) {
		int index=-1;
		if(array==null||array.length==0)
			return index;
		int start=0,end=array.length-1;
		while(start<end){
			int mid=(start+end)/2;
			if(array[mid]<k){
				start=mid+1;
			}else {
				end=mid;
			}
		}
		if(array[end]==k)
			index=end;
		return index;
	}
	private static int getIndexOfLastK(int [] array , int k) {
		int index=-1;
		if(array==null||array.length==0)
			return index;
		int start=0,end=array.length-1;
		while(start<end-1){
			int mid=(start+end)/2;
			if(array[mid]>k){
				end=mid;
			}else {
				start=mid;
			}
		}
		if(array[end]==k)
			index=end;
		else if(array[start]==k)
			index=start;
		return index;
	}
	public static void main(String[] args) {
		int [] array= {1,2,3,4,4,4,5,5,5,6,7};
		int left=getIndexOfFirstK(array, 2);
		int right=getIndexOfLastK(array,2);
		System.out.println(left+":"+right);
		int count=GetNumberOfK(array,1);
		System.out.println(count);
	}
}
