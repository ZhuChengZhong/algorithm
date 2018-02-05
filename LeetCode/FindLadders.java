package com.zhu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class FindLadders {
	 public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		 ArrayList<String>list=new ArrayList<String>();
	     list.add(start);
	     ArrayList<ArrayList<String>>result=new ArrayList<ArrayList<String>>();
	     findLadders(result, start, end, dict, list);
	     return result;
	 }
	 private  int min=0x7fffffff;
	 public void findLadders(ArrayList<ArrayList<String>>result,String start, String end, HashSet<String> dict,ArrayList<String>list) {
		 if(list.size()>=min)
			 return;
		 if(isACharDiff(start, end)){
			 list.add(end);
			 if(list.size()<=min){
				 min=list.size();
				 result.add(new ArrayList<String>(list));
			 }
			 list.remove(list.size()-1);
		 }
		  for(String s:dict){   
		    	 if(isACharDiff(start, s)&&!list.contains(s)){
		    		 list.add(s);
		    		 findLadders(result,s, end, dict,list);
		    		 list.remove(list.size()-1);
		    	 }
		     }
	 }
	 private static boolean isACharDiff(String s1,String s2){
		 if(s1.length()!=s2.length())
			return false;
		 boolean flag=false;
		 for(int i=0;i<s1.length();i++){
			 if(s1.charAt(i)!=s2.charAt(i)){
				 if(flag)
					 return false;
				 flag=true;
			 }
		 }
		 return flag;
	 }
	 public static void main(String[] args) {
		HashSet<String>set=new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		 ArrayList<ArrayList<String>>result=new FindLadders().findLadders("hit","cog",set);
		 System.out.println(result);
	}
}
