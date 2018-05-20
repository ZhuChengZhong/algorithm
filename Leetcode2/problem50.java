package leetcode;
/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000

示例 2:

输入: 2.10000, 3
输出: 9.26100

示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25

说明:

    -100.0 < x < 100.0
    n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。


 * @author zhu
 *
 */
public class problem50 {
    public static double myPow(double x, int n) {
    	long m=n;
        boolean b=m<0?true:false;
         m=b?-m:m;
        double result=1;
        while(m>0) {
        	if((m&1)==1) {
        		result*=x;
        	}
        	x=x*x;
        	m=m>>1;
        }
        return b?1/result:result;
    }
    public static void main(String[] args) {
    	System.out.println(myPow(2, 1<<31));
		System.out.println(myPow(2, 10));
		System.out.println(myPow(2.1, 3));
		System.out.println(myPow(2, -2));
	}
}
