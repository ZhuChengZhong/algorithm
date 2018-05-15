package leetcode;

public class problem58 {
    public static int lengthOfLastWord(String s) {
    	if(s==null) {
    		return 0;
    	}
    	int right=s.length()-1;
    	while(right>=0&&s.charAt(right)==' ') {
    		right--;
    	}
    	if(right<0) {
    		return 0;
    	}
    	int left=right;
    	while(left>=0&&s.charAt(left)!=' ') {
    		left--;
    	}
        return right-left;
    }
    public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello Wosrld  "));
	}
}
