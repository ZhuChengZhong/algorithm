package com.zhu.leetcode;

import java.util.Arrays;

/**
 *  Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.

A region is captured by flipping all'O's into'X's in that surrounded region .

For example,

X X X X
X O O X
X X O X
X O X X


After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

 * @author Administrator
 *
 */
public class Flipping {
	
	 public void solve(char[][] board) {
		 if(board==null||board.length==0){
			 return;
		 }
		 int row=board.length;
		 int col=board[0].length;
		 boolean [][]visited=new boolean[row][col];
		 for(int i=0;i<row;i++){
			if(board[i][0]=='O'&&!visited[i][0]){
				solve(i,0,board,visited,row,col);
			}
			if(board[i][col-1]=='O'&&!visited[i][col-1]){
				solve(i,col-1,board,visited,row,col);
			}
		 }
		 for(int i=0;i<col;i++){
				if(board[0][i]=='O'&&!visited[0][i]){
					solve(0,i,board,visited,row,col);
				}
				if(board[row-1][i]=='O'&&!visited[row-1][i]){
					solve(row-1,i,board,visited,row,col);
				}
		 }
		 for(int i=0;i<row;i++){
			 for(int j=0;j<col;j++){
				 if(!visited[i][j]){
					 board[i][j]='X';
				 }
			 }
		 }
	 }
	 int a[]={1,-1,0,0},b[]={0,0,-1,1};
	 private void solve(int x,int y,char[][] board,boolean[][]visited,int row,int col){
		 visited[x][y]=true;
		 int xx,yy;
		  for(int i=0;i<4;i++){
			  xx=x+a[i];
			  yy=y+b[i];
			  if(xx>=0&&xx<row&&yy>=0&&yy<col&&board[xx][yy]=='O'&&!visited[xx][yy]){
				  
				  solve(xx,yy,board,visited,row,col);
			  }
		  }
	 }
	 public static void main(String[] args) {
		char[][] board={
				{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','O','O','X'},
				{'X','O','X','X'}
		};
		new Flipping().solve(board);
		System.out.println(board);
	}
}
