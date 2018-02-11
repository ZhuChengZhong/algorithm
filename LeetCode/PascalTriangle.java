package com.zhu.leetcode;

import java.util.ArrayList;

/**
 * 

Given an index k, return the k th row of the Pascal's triangle.

For example, given k = 3,
Return[1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space? 
 * @author Administrator
 *
 */
public class PascalTriangle {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list=new ArrayList<Integer>(rowIndex+2);
        if (rowIndex==0) {
        	list.add(1);
        	return list;
        }
        list.add(1);
        list.add(1);
        for(int i=2;i<=rowIndex;i++) {
        	int j;
        	list.add(1);
        	for(j=i-1;j>=1;j--) {
        		int m=list.get(j-1);
        		int n=list.get(j);
        		list.set(j, m+n);
        	}
        }
        return list;
    }
    public static void main(String[] args) {
		System.out.println(new PascalTriangle().getRow(1));
	}
}
