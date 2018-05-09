package com.zhu.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;



public class LadderLength {
	 public int ladderLength(String start, String end, HashSet<String> dict) {
		 if(isACharDiff(start, end)){
			 return 2;
		 }
		 LinkedList<String> queue=new LinkedList<String>();
		 LinkedList<String>queue2=new LinkedList<String>();
		 queue.add(start);
		 int min=0;
		while(true){
			 min++;
			 while(!queue.isEmpty()){
				 String s=queue.pop();
				 if(isACharDiff(s, end)){
					 return ++min;
				 }
				 if(dict.isEmpty())
					 return 0;
				 java.util.Iterator<String> it=dict.iterator();
				 while(it.hasNext()){
					 String s1=it.next();
					 if(isACharDiff(s, s1)){
						 queue2.add(s1);
						 it.remove();
					 }
				 }
			 }
			 if(queue2.isEmpty())
				 return 0;
			 queue.addAll(queue2);
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
		 int result=new LadderLength().ladderLength("hit","cog",set);
		 System.out.println(result);
	}
}
