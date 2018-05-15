package leetcode;

import java.util.Arrays;
/**
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。

示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。


 * @author zhu
 *
 */
public class problem66 {
    public static int[] plusOne(int[] digits) {
        if(digits==null) {
        	return null;
        }
        for(int i=digits.length-1;i>=0;i--) {
        	if(digits[i]==9) {
        		if(i==0) {
        			int []res=new int[digits.length+1];
        			res[0]=1;
        			return res;
        		}
        		digits[i]=0;
        	}else {
        		digits[i]+=1;
        		break;
        	}
        }
        return digits;
    }
    public static void main(String[] args) {
		int []arr= {9,9,9,9};
		System.out.println(Arrays.toString(plusOne(arr)));
	}
}
