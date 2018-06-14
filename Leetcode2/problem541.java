package leetcode;
/**
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。

示例:

输入: s = "abcdefg", k = 2
输出: "bacdfeg"

要求:

    该字符串只包含小写的英文字母。
    给定字符串的长度和 k 在[1, 10000]范围内。


 * @author zhu
 *
 */
public class problem541 {
    public static String reverseStr(String s, int k) {
        char[]arr=s.toCharArray();
        int start=0;
        int end=k-1;
        while(end<s.length()) {
        	reverse(arr, start, end);
        	start=start+2*k;
        	end=end+2*k;
        }
        if(start<s.length()) {
        	reverse(arr, start, s.length()-1);
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
		System.out.println(reverseStr("abcdefg", 1));
	}
}
