package com.zhu.practice;

import java.util.Stack;
/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * @author Administrator
 * 思路：通过一个辅助栈用来保存每次添加元素时的最小值
 */
public class MinStack {
	private Stack stack=new Stack();
	private Stack minStack=new Stack();
	public void push(int node) {
		stack.push(node);
		if(minStack.isEmpty()||(int)minStack.peek()>node){
			minStack.push(node);
		}else{
			minStack.push((int)minStack.peek());
		}
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top(){
        return (int)stack.peek();
    }
    
    public int min() {
    	return (int)minStack.peek();
        
    }
    public static void main(String[] args) {
		MinStack stack=new MinStack();
		stack.push(5);
		stack.push(7);
		stack.push(3);
		stack.push(9);
		stack.push(1);
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
	}
}
