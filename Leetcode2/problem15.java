package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]


 * @author zhu
 *
 */
public class problem15 {
    public static List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> result=new ArrayList<>();
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length;i++) {
    		if(i>0&&nums[i]==nums[i-1]) {
    			continue;
    		}
    		int left=i+1,right=nums.length-1;
    		while(left<right) {
    			if(right<nums.length-1&&nums[right]==nums[right+1]) {
    				right--;
    				continue;
    			}
    			int temp=nums[left]+nums[right]+nums[i];
    			if(temp==0) {
    				ArrayList<Integer>array=new ArrayList<>();
					array.add(nums[i]);
					array.add(nums[left]);
					array.add(nums[right]);
    				int j;
    				result.add(array);
    				left++;
    				right--;
    			}else if(temp<0) {
    				left++;
    			}else {
    				right--;
    			}
    		}
    	}
        return result;
    }
    public static void main(String[] args) {
    	//int []nums= {-1, 0, 1, 2, -1, -4};
    	int [] nums= {-2,0,0,2,2};
		System.out.println(threeSum(nums));
	}
}
