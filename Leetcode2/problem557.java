package leetcode;
/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 

注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

 * @author zhu
 *
 */
public class problem557 {
    public static String reverseWords(String s) {
        if(s==null||s.length()<2) {
        	return s;
        }
        char[]arr=s.toCharArray();
       // reverse(arr, 0, arr.length-1);
        int index=0;
        int left=0,right=0;
        int len=arr.length;
        while(index<len) {
        	while(index<len&&arr[index]==' ') {
        		index++;
        	}
        	left=index;
        	while(index<len&&arr[index]!=' ') {
        		index++;
        	}
        	right=index-1;
        	if(left>=len) {
        		break;
        	}
        	reverse(arr, left, right);
        }
        return new String(arr);
    }
    private static void reverse(char[]arr,int start,int end) {
    	while(start<end) {
    		char temp=arr[start];
    		arr[start]=arr[end];
    		arr[end]=temp;
    		start++;
    		end--;
    	}
    }
    public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}
}
