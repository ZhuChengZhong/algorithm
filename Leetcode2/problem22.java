package leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]


 * @author zhu
 *
 */
public class problem22 {
    public static List<String> generateParenthesis(int n) {
    	List<String> result=new ArrayList<String>();
    	generateParenthesis(result,n,n,new StringBuilder());
        return result;
    }
    public static void generateParenthesis(List<String> result,
    		int l,int r,StringBuilder sb) {
    	if(l==0&&r==0) {
    		result.add(sb.toString());
    	}
    	if(l>0) {
    		sb.append("(");
    		generateParenthesis(result, l-1, r, sb);	
    		sb.deleteCharAt(sb.length()-1);
    	}
    	if(l<r) {
    		sb.append(")");
    		generateParenthesis(result, l, r-1, sb);	
    		sb.deleteCharAt(sb.length()-1);
    	}
    }
    public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}
}
