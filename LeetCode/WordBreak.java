package com.zhu.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 *  Given a string s and a dictionary of words dict,
 *   add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s ="catsanddog",
dict =["cat", "cats", "and", "sand", "dog"].

A solution is["cats and dog", "cat sand dog"]. 
 * @author Administrator
 *
 */
public class WordBreak {
	   public static ArrayList<String> wordBreak(String s, Set<String> dict){
		   if(s==null||dict==null)
			   return null;
		   ArrayList<String> list=new ArrayList<String>();
		   wordBreak(list, "", s,0,0, dict);
	       return list;
	   }
	   private static void wordBreak(ArrayList<String>list,String result,String s,int start,int end,Set<String> dict){
		   if(start==end&&start==s.length()){
			   list.add(result);
		   }
		   if(end==s.length())
			   return ;
		   wordBreak(list,result,s,start,end+1,dict);
		   String str=s.substring(start, end+1);
		   if(dict.contains(str)){
			   if("".equals(result)){
				   wordBreak(list,str,s, end+1, end+1, dict);
			   }else{
				   wordBreak(list,result+" "+str,s, end+1, end+1, dict);
			   }
		   }
		   
	   }
	   public static void main(String[] args) {
		String s="catsanddog";
		Set<String> set=new HashSet<String>();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		System.out.println(wordBreak(s,set));
	}
}
