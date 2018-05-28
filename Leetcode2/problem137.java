package leetcode;
/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,3,2]
输出: 3

示例 2:

输入: [0,1,0,1,0,1,99]
输出: 99


 * @author zhu
 *
 */
public class problem137 {
    public static int singleNumber(int[] nums) {
       int one=0,two=0,three=0;
        for(int i=0;i<nums.length;i++) {
        	two|=one&nums[i];
        	one=one^nums[i];
        	three=one&two;
        	two=two^three;
        	one=one^three;
        }
        return one;
    }
    public static void main(String[] args) {
    	int [] arr= {2,2,2,7,3,3,3};
		System.out.println(singleNumber(arr));
	}
}
