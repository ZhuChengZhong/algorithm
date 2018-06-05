package leetcode;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"

示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"


 * @author zhu
 *
 */
public class problem32 {
    public static int longestValidParentheses(String s) {
        char[]arr=s.toCharArray();
        boolean[] mark=new boolean[arr.length];
        Stack<Integer>stack=new Stack<>();
        int max=0,sum=0;
        for(int i=0;i<arr.length;i++) {
        	char c=arr[i];
        	if(c=='(') {
        		stack.push(i);
        	}else {
        		if(!stack.isEmpty()) {
        			int index=stack.pop();
        			mark[index]=true;
        			mark[i]=true;
        		}
        	}
        }
        for(int i=0;i<mark.length;i++) {
        	if(mark[i]) {
        		sum++;
        	}else {
        		max=Math.max(sum, max);
        		sum=0;
        	}
        }
        max=Math.max(sum, max);
        return max;
    }
    public static void main(String[] args) {
		//String s=")(())";
    	String s="()(())";
		System.out.println(longestValidParentheses(s));
	}
}
