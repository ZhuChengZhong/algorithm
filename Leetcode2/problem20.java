package com.zhu.test;

import java.util.Stack;
/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。

注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true

示例 2:

输入: "()[]{}"
输出: true

示例 3:

输入: "(]"
输出: false

示例 4:

输入: "([)]"
输出: false

示例 5:

输入: "{[]}"
输出: true


 * @author zhu
 *
 */
public class problem20 {
	public static boolean check(Stack stack,char b) {
		if(stack.size()==0) {
			return false;
		}
		char a=(char)stack.peek();
		if(a=='('&&b==')') {
			stack.pop();
			return true;
		}
		if(a=='['&&b==']') {
			stack.pop();
			return true;
		}
		if(a=='{'&&b=='}') {
			stack.pop();
			return true;
		}
		return false;
	}
    public static boolean isValid(String s) {
        Stack stack=new Stack();
        for(int i=0;i<s.length();i++) {
        	char c=s.charAt(i);
        	if(c=='('||c=='{'||c=='[') {
        		stack.push(c);
        	}else {
        		if(!check(stack, c)) {
        			return false;
        		}
        	}
        }
        if(!stack.empty()) {
        	return false;
        }
        return true;
    }
    public static void main(String[] args) {
		String s="{()[]}";
		System.out.println(isValid(s));
	}
}