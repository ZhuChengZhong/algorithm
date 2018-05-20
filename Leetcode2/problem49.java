package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

说明：

    所有输入均为小写字母。
    不考虑答案输出的顺序。


 * @author zhu
 *
 */
public class problem49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
    	Map<String,List<String>>map=new HashMap<>();
    	int []count=new int[26];
        for(int i=0;i<strs.length;i++) {
        	String s=strs[i];
        	for(int j=0;j<s.length();j++) {
        		count[s.charAt(j)-'a']++;
        	}
        	StringBuilder sb=new StringBuilder();
        	for(int j=0;j<26;j++) {
        		while(count[j]>0) {
        			sb.append(j+'a');
        			count[j]--;
        		}
        	}
        	String key=sb.toString();
        	List<String>list=map.get(key);
        	if(list==null) {
        		list=new ArrayList<>();
        		map.put(key, list);
        	}
        	list.add(s);
        }
        List<List<String>>result=new ArrayList<>();
        for(List<String>l:map.values()) {
        	result.add(l);
        }
        return result;
    }
    public static void main(String[] args) {
		String[] strs= {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strs));
	}
}
