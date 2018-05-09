package com.zhu.leetcode;

import java.util.ArrayList;
/**
 * 

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 * @author Administrator
 *
 */
public class PascalTriangle2 {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	
    	ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    	if(numRows==0)
    		return result;
    	numRows-=1;
    	ArrayList<Integer> lt=new ArrayList<Integer>(1);
    	lt.add(1);
    	result.add(lt);
         for(int i=1;i<=numRows;i++) {
        	ArrayList<Integer> list=new ArrayList<Integer>(i+1);
         	int j;
         	list.add(1);
         	ArrayList<Integer> preList=result.get(i-1);
         	for(j=1;j<i;j++) {
         		int m=preList.get(j-1);
         		int n=preList.get(j);
         		list.add(m+n);
         	}
         	list.add(1);
         	result.add(list);
         }
         return result;
    }
    public static void main(String[] args) {
		System.out.println(new PascalTriangle2().generate(5));
	}
}
