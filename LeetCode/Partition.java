package com.zhu.leetcode;

import java.util.ArrayList;
/**
 * 

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s ="aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]

 * @author Administrator
 *
 */
public class Partition {
	public ArrayList<ArrayList<String>> partition(String s) {
		int len=s.length();
        boolean [][]p=new boolean[len][len];
        for(int i=0;i<len;i++){
        	for(int j=i;j>=0;j--){
        		if(s.charAt(i)==s.charAt(j)&&(i-j<2||p[j+1][i-1])){
        			p[j][i]=true;
        		}
        	}
        }
        ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
        parttion(list,s,0,len,p,new ArrayList<String>());
        return list;
    }
	private void parttion(ArrayList<ArrayList<String>> result,String s,int index,int len,boolean[][] p,ArrayList<String>list){
		if(index==len){
			result.add(new ArrayList<String>(list));
		}
		for(int i=index;i<len;i++){
			if(p[index][i]){
				String str=s.substring(index, i+1);
				list.add(str);
				parttion(result,s, i+1, len, p,list);
				list.remove(list.size()-1);
			}
		 }
	}
	public static void main(String[] args) {
		String s="abbab";
		System.out.println(new Partition().partition(s));
	}
}
