package com.zhu.practice;

import java.util.ArrayList;

public class PrintMatrix {
	/*public static ArrayList<Integer> printMatrix(int [][] matrix) {
		if(matrix==null){
			return null;
		}
		ArrayList<Integer> result=new ArrayList<Integer>();
		int row=matrix.length;
		int col=matrix[0].length;
		int n=1,k=1,x=0,y=0,count=row*col,index=1;
		if(count==1){
			result.add(matrix[0][0]);
			return result;
		}
		while(index<=count){
			for(int i=1;i<=col-n;i++){
				result.add(matrix[x][y]);
				y+=k;
				if(++index>count){
					break;
				}
			}
			for(int i=1;i<=row-n;i++){
				result.add(matrix[x][y]);
				x+=k;
				if(++index>count){
					break;
				}
			}
			
			k=-k;
			//k再次等于1的时候说明循环了一圈
			if(k==1){
				n+=2;
				x+=1;
				y+=1;
			}
		}
	    return result;
    }*/
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
		if(matrix==null){
			return null;
		}
		ArrayList<Integer> result=new ArrayList<Integer>();
		int row=matrix.length;
		int col=matrix[0].length;
		int n=((row<col?row:col)+1)/2;
		for(int i=0;i<n;i++){
			//从左到右
			for(int j=i;j<col-i;j++)
				result.add(matrix[i][j]);
			//从上到下
			for(int j=i+1;j<row-i-1;j++)
				result.add(matrix[j][col-i-1]);
			//从右到左
			if(row-i-1!=i)
			for(int j=col-i-1;j>=i;j--)
				result.add(matrix[row-i-1][j]);
			//从下到上
			if(col-i-1!=i)
			for(int j=row-i-2;j>=i+1;j--)
				result.add(matrix[j][i]);
		}
		return result;
    }
	public static void main(String[] args) {
		/*int [][] martix={
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};*/
		/*int [][] martix={
				{1},
				{5},
				{9},
				{13}
		};*/
		int [][] martix={
				{1},
				{2},
				{3},
				{4},
				{5}
				
		};
		/*int [][] martix={{1}};*/
		
		ArrayList<Integer>result=printMatrix(martix);
		for(int num:result){
			System.out.print(num+",");
		}
	}
}
