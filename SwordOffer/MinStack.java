package com.zhu.practice;

import java.util.Stack;
/**
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 * @author Administrator
 * ˼·��ͨ��һ������ջ��������ÿ�����Ԫ��ʱ����Сֵ
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
