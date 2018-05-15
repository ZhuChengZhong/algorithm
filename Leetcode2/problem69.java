package leetcode;
/**
 * 实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2

示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。


 * @author zhu
 *
 */
public class problem69 {
    public static int mySqrt(int x) {
    	int left=0,right=x;
    	if(x>(1<<16)) {
    		right=1<<16;
    	}
    	while(left<right) {
    		int mid=(left+right+1)>>1;
    		long temp=(long)mid*mid;
    	    if(temp>x) {
    	    	right=mid-1;
    	    }else {
    	    	left=mid;
    	    }
    	}
        return left;
    }
    public static void main(String[] args) {
			//System.out.println(mySqrt(2147395599));
    	final byte a=1;
    	final byte b=2;
    	byte c=a+b;
	}
}
