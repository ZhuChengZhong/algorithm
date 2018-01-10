package com.algorithm.offer;
/*
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 
 * 思路，先将整个句子翻转，再将每个单词翻转就是结果
 * */

public class ReverseSentence {
	public static String reverseSentence(String str) {
		char[] chars=new char[str.length()];
        str.getChars(0, str.length(),chars,0);
        int start=0,end=str.length()-1;
        reverse(chars,start,end);
        int begin=0;
        for(int i=0;i<=str.length();i++) {
        	if(i==str.length()||chars[i]==' ') {
        		reverse(chars,begin,i-1);
        		begin=i+1;
        	}
        	
        }
        return new String(chars);
    }
	private static void reverse(char[] chars,int start,int end) {	 
        while(start<end) {
        	char temp=chars[start];
        	chars[start]=chars[end];
        	chars[end]=temp;
        	start++;
        	end--;
        }
	}
	public static void main(String[] args) {
		String result=reverseSentence("I am a student.");
		System.out.println(result);
	}
}
