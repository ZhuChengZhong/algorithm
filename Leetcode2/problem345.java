package leetcode;

public class problem345 {
    public static String reverseVowels(String s) {
        int left=0,right=s.length()-1;
        char[]arr=s.toCharArray();
        while(left<right) {
        	while(!isVowel(arr[left])&&left<right) {
        		left++;
        	}
        	while(!isVowel(arr[right])&&left<right) {
        		right--;
        	}
        	if(left>=right) {
        		break;
        	}
        	char temp=arr[left];
        	arr[left]=arr[right];
        	arr[right]=temp;
        	left++;
        	right--;
        }
        return new String(arr);
    }
    public static boolean isVowel(char c) {
    	if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
    		return true;
    	}
    	if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U') {
    		return true;
    	}
    	return false;
    }
    public static void main(String[] args) {
    	//String s="hello";
    	String s="OE";
		System.out.println(reverseVowels(s));
	}
}
