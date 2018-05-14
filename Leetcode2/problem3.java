package leetcode;

import java.util.Arrays;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。

示例：

给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。

给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。

给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。

 * @author zhu
 *
 */
public class problem3 {
    public static int lengthOfLongestSubstring(String s) {
    	if(s==null) {
    		return 0;
    	}
        boolean []mark=new boolean[256];
        int max=0,sum=0;
        int left=0;
        for(int i=0;i<s.length();i++) {
        	if(mark[s.charAt(i)]) {
        		while(s.charAt(left)!=s.charAt(i)) {
        			mark[s.charAt(left)]=false;
        			left++;
        		}
        		mark[s.charAt(left)]=false;
        		left++;
        	}
        	mark[s.charAt(i)]=true;
        	if((i-left+1)>max) {
        		max=i-left+1;
        	}
        }
        return max;
    }
    public static void main(String[] args) {
		String s="dvdf";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
