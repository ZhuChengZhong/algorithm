package com.zhu.leetcode;
/**
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama"is a palindrome.
"race a car"is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome. 
 * @author Administrator
 *
 */
public class IsPalindrome {
	 public boolean isPalindrome(String s) {
	    if(s==null||"".equals(s))
	    	return true;
	    s=s.replaceAll("[^0-9a-zA-Z]", "");
	    int start=0,end=s.length()-1;
	    while(start<end){
	    	if(!same(s.charAt(start),s.charAt(end)))
	    			return false;
	    	++start;
	    	--end;
	    }
	    return true;
	 }
	 private static boolean same(char c1,char c2){
		 if(c1==c2)
			 return true;
		 if(c1+32==c2||c2+32==c1)
			 return true;
		 return false;
	 }
	 public static void main(String[] args) {
		String s="A man, a plan, a canal: Panama";
		System.out.println(new IsPalindrome().isPalindrome(""));
		
	}
}
