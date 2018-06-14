package leetcode;
/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

示例 1:

输入: "abab"

输出: True

解释: 可由子字符串 "ab" 重复两次构成。

示例 2:

输入: "aba"

输出: False

示例 3:

输入: "abcabcabcabc"

输出: True

解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)


 * @author zhu
 *
 */
public class problem459 {
    public static boolean repeatedSubstringPattern(String s) {
        int len=s.length();
        for(int i=1;i<=s.length()/2;i++) {
        	if(s.length()%i!=0) {
        		continue;
        	}
        	boolean over=true;
        	for(int j=i;j<s.length();j++) {
        		if(s.charAt(j%i)!=s.charAt(j)) {
        			over=false;
        			break;
        		}
        	}
        	if(over) {
        		return true;
        	}
        }
        return false;
    }
    public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("abcabcabc"));
	}
}
