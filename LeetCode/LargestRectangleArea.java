package leetcode;

import java.util.Stack;

public class LargestRectangleArea {
    public static int largestRectangleArea(int[] height) {
        if(height==null||height.length==0){
            return 0;
        }
        int max=0;
        Stack<Integer>stack=new Stack<>();
        stack.push(-1);
        for(int i=0;i<height.length;i++){
            while(stack.peek()!=-1&&height[stack.peek()]>height[i]){
                int h=stack.pop();
                int area=(i-1-stack.peek())*height[h];
                max=max>area?max:area;
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){
            int h=stack.pop();
             int area=(height.length-1-stack.peek())*height[h];
            max=max>area?max:area;
        }
        return max;
    }
    public static void main(String[] args) {
		int[]height={0};
		System.out.println(largestRectangleArea(height));
	}
}
