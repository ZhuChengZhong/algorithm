package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

 * @author zhu
 *
 */
public class problem17 {
	private static Map<Integer,String>map=new HashMap<>();
	static {
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
	}
    public static List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits==null||"".equals(digits)) {
        	return result;
        }
        letterCombinations(digits,0,result,new StringBuilder());
        return result;
    }
    public static void letterCombinations(String digits,int index, List<String> result,StringBuilder sb) {
    	if(index==digits.length()) {
    		result.add(sb.toString());
    		return ;
    	}
    	String s=map.get(digits.charAt(index)-'0');
    	for(int i=0;i<s.length();i++) {
    		sb.append(s.charAt(i));
    		letterCombinations(digits, index+1, result, sb);
    		sb.deleteCharAt(index);
    	}
    }
    public static void main(String[] args) {
		System.out.println(letterCombinations("2"));
	}
}
