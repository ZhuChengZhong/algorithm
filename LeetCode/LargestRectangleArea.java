package leetcode;

import java.util.Stack;

public class LargestRectangleArea {
	   public int largestRectangleArea(int[] height) {
	        if(height==null||height.length==0){
	            return 0;
	        }
	        int max=0;
	        Stack<Integer>stack=new Stack<>();
	        for(int i=0;i<height.length;i++){
	            int width=0;
	            while(!stack.isEmpty()&&stack.peek()>height[i]){
	                width++;
	                int h=stack.pop();
	                int area=h*width;
	                max=max>area?max:area;
	            }
	            while(width>=0){
	                stack.push(height[i]);
	                width--;
	            }
	        }
	        int width=0;
	        while(!stack.isEmpty()){
	            width++;
	            int h=stack.pop();
	            int area=h*width;
	            max=max>area?max:area;
	        }
	        return max;
	    }
}
