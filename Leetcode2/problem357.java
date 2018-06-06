package leetcode;
/**
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n。

示例:
给定 n = 2，返回 91。（答案应该是除[11,22,33,44,55,66,77,88,99]外，0 ≤ x < 100 间的所有数字）

致谢:
特别感谢 @memoryless 添加这个题目并创建所有测试用例。

 * @author zhu
 *
 */
public class problem357 {
    public static int countNumbersWithUniqueDigits(int n) {
    	if(n==0) {
    		return 1;
    	}
    	int res=10,count=9;
    	for(int i=1;i<n;i++) {
    		count*=(10-i);
    		res+=count;
    	}
    	return res;
    }

    public static void main(String[] args) {
		System.out.println(countNumbersWithUniqueDigits(3));
	}
}
