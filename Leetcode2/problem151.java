package leetcode;
/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。

示例:  

输入: "the sky is blue",
输出: "blue is sky the".

说明:

    无空格字符构成一个单词。
    输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
    如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

进阶: 请选用C语言的用户尝试使用 O(1) 时间复杂度的原地解法。

 * @author zhu
 *
 */
public class problem151 {
    public static String reverseWords(String s) {
        char[] array=s.trim().toCharArray();
        int r=array.length-1;
        int l=0;
        int index=-1;
        for(int i=l;i<=r;i++) {
        	if(index>=0&&array[i]==array[index]&&array[index]==' ') {
        		continue;
        	}
        	array[++index]=array[i];
        }
        r=index;
        reverse(array, l, r);
        int left=0;
        for(int i=1;i<=r;i++) {
        	if(array[i]==' ') {
        		if(left<i) {
        			reverse(array, left, i-1);	
        		}
        		left=i+1;
        	}
        }
        reverse(array, left, r);
        return new String(array,0,r+1);
    }
    private static void reverse(char[]array,int l,int r) {
    	  while(l<r) {
          	char c=array[l];
          	array[l]=array[r];
          	array[r]=c;
          	l++;
          	r--;
          }
    }
    public static void main(String[] args) {
		String s="   a   b  c d   e  ";
		System.out.println(reverseWords(s));
	}
}
