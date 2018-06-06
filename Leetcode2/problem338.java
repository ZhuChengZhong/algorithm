package leetcode;

import java.util.Arrays;

/**
 * 给定一个非负整数 num。 对于范围 0 ≤ i ≤ num 中的每个数字 i ，计算其二进制数中的1的数目并将它们作为数组返回。

示例：
比如给定 num = 5 ，应该返回 [0,1,1,2,1,2].

进阶：

    给出时间复杂度为O(n * sizeof(integer)) 的解答非常容易。 但是你可以在线性时间O(n)内用一次遍历做到吗？
    要求算法的空间复杂度为O(n)。
    你能进一步完善解法吗？ 在c ++或任何其他语言中不使用任何内置函数（如c++里的 __builtin_popcount）来执行此操作。

致谢：
特别感谢 @syedee 添加此问题及所有测试用例。

 * @author zhu
 *
 */
public class problem338 {
    public static int[] countBits(int num) {
        int[]res=new int[num+1];
        int n=1;
        for(int i=1;i<=num;i++) {
        	if(i==n*2) {
        		n*=2;
        	}
        	res[i]=res[i-n]+1;
        }
        return res;
    }
    public static void main(String[] args) {
		System.out.println(Arrays.toString(countBits(5)));
	}
}
