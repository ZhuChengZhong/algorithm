package leetcode;

import java.util.Arrays;

/**
 * 给定一组字符，使用原地算法将其压缩。

压缩后的长度必须始终小于或等于原数组长度。

数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。

在完成原地修改输入数组后，返回数组的新长度。

 

进阶：
你能否仅使用O(1) 空间解决问题？
示例 1：

输入：
["a","a","b","b","c","c","c"]

输出：
返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]

说明：
"aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。

示例 2：

输入：
["a"]

输出：
返回1，输入数组的前1个字符应该是：["a"]

说明：
没有任何字符串被替代。

示例 3：

输入：
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

输出：
返回4，输入数组的前4个字符应该是：["a","b","1","2"]。

说明：
由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
注意每个数字在数组中都有它自己的位置。

 * @author zhu
 *
 */
public class problem443 {
    public static int compress(char[] chars) {
        int i=0,index=0;
        int len=chars.length;
        while(i<len) {
        	char c=chars[i++];
        	chars[index++]=c;
        	int count=1;
        	while(i<len&&chars[i]==c) {
        		count++;
        		i++;
        	}
        	if(count>1) {
        		int n=1;
        		while(count/(n*10)>0) {
        			n*=10;
        		}
        		while(n>0) {
        			int a=count/n;
        			chars[index++]=(char) ('0'+a);
        			count=count%n;
        			n/=10;
        		}
        	}
        }
        return index;
    }
    public static void main(String[] args) {
    	//char[]chars= {'a','b','b','c','c','c','d'};
    	char[]chars= {'a','a','a','a','a','a','a','a','a','a'};
		System.out.println(compress(chars));
		System.out.println(Arrays.toString(chars));
	}
}
