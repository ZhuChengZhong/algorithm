package com.zhu.leetcode;
/**
 * 计算后缀表达式的结果
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * @author Administrator
 *
 */
public class EvalRPN {
	public static int evalRPN(String[] tokens) {
       int[] stack=new int[100];
       int index=-1;
       for(int i=0;i<tokens.length;i++){
    	   String str=tokens[i];
    	   if(str.length()==1&&!(str.charAt(0)>='0'&&str.charAt(0)<='9')){
    		   int n2=stack[index--];
    		   int n1=stack[index--];
    		   int result=computer(n1, n2, str.charAt(0));
    		   stack[++index]=result;
    	   }else{
    		   int number=Integer.parseInt(str);
    		   stack[++index]=number;
    	   }
       }
       return stack[0];
    }
	private static int computer(int n1,int n2,char oper){
		int result=0;
		switch (oper) {
		case '*':
			result=n1*n2;
			break;
		case '/':
			result=n1/n2;
			break;
		case '+':
			result=n1+n2;
		break;
		case '-':
			result=n1-n2;
		break;
		}
		return result;
	}
	public static void main(String[] args) {
		/*String[] tokens={"2", "1", "+", "3", "*"};*/
		String[] tokens={"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(tokens));
	}
}
