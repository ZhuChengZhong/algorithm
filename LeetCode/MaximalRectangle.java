package leetcode;

import java.util.Stack;

public class MaximalRectangle {
	   public static int maximalRectangle(char[][] matrix) {
	        if(matrix==null||matrix.length==0){
	            return 0;
	        }
	        int max=0;
	        Stack<Integer>stack=new Stack<>();
	        int m=matrix.length,n=matrix[0].length;
	        int[]h=new int[n+1];
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                if(matrix[i][j]=='1'){
	                    h[j]=h[j]+1;
	                }else{
	                    h[j]=0;
	                }
	            }
	            stack.push(-1);
	            for(int j=0;j<=n;j++){
	                while(stack.peek()!=-1&&h[stack.peek()]>h[j]){
	                    int high=stack.pop();
	                    int area=(j-1-stack.peek())*h[high];
	                    max=max>area?max:area;
	                }
	                stack.push(j); 
	            }
	            while(!stack.isEmpty()){
	            	stack.pop();
	            }
	        }
	        return max;
	    }
	   public static void main(String[] args) {
		char[][]matrix={{'1','0'},{'1','0'}};
		System.out.println(maximalRectangle(matrix));
	}
}
