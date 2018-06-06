package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

    拆分时可以重复使用字典中的单词。
    你可以假设字典中没有重复的单词。

示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。

示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false


 * @author zhu
 *
 */
public class problem139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        char[]arr=s.toCharArray();
        boolean[]mark=new boolean[arr.length+1];
        mark[0]=true;
        for(int i=0;i<arr.length;i++) {
        	for(int j=0;j<wordDict.size();j++) {
        		String str=wordDict.get(j);
        		if(str.length()<=i+1&&mark[i+1-str.length()]) {
        			int k=0;
        			for(k=str.length()-1;k>=0;k--) {
        				if(str.charAt(k)!=arr[i-(str.length()-1-k)]) {
        					break;
        				}
        			}
        			if(k==-1) {
        				mark[i+1]=true;
        			}
        		}
        	}
        }
        if(mark[arr.length]) {
        	return true;
        }
        return false;
    }
    public static void main(String[] args) {
		List<String>list=new ArrayList<>();
		list.add("apple");
		list.add("pen");
		String s="applepenapple";
		System.out.println(wordBreak(s, list));
	}
}
