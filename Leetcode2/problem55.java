package leetcode;
/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。

示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。


 * @author zhu
 *
 */
public class problem55 {
    public static boolean canJump(int[] nums) {
        if(nums==null) {
        	return false;
        }
        boolean[] mark=new boolean[nums.length];
        mark[nums.length-1]=true;
        for(int i=nums.length-1;i>=0;i--) {
        	for(int j=1;j<=nums[i]&&(i+j)<nums.length;j++) {
        		int index=i+j;
        		if(mark[index]==true) {
        			mark[i]=true;
        			break;
        		}
        	}
        }
        return mark[0];
    }
    public static void main(String[] args) {
		//int[]nums= {2,3,1,1,4};
		int[]nums= {3,2,1,0,4};
		System.out.println(canJump(nums));
	}
}
