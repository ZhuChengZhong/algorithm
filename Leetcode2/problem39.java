package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

    所有数字（包括 target）都是正整数。
    解集不能包含重复的组合。 

示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]

示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]


 * @author zhu
 *
 */
public class problem39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result=new ArrayList<>();
    	combinationSum(candidates, 0, 0, new ArrayList<>(), result, target);
    	return result;
    }
    public static void combinationSum(int[] candidates,int index,int sum,List<Integer>arr,List<List<Integer>>result, int target) {
    	if(sum==target) {
    		result.add(new ArrayList<>(arr));
    		return ;
    	}
    	if(index==candidates.length) {
    		return ;
    	}
    	int n=(target-sum)/candidates[index];
        for(int i=0;i<=n;i++) {
        	combinationSum(candidates, index+1, sum+candidates[index]*i, arr, result, target);
        	arr.add(candidates[index]);
        }
        for(int i=0;i<=n;i++) {
        	arr.remove(arr.size()-1);
        }
    }
    public static void main(String[] args) {
		int []candidates = {2,3,5};int target = 8;
		System.out.println(combinationSum(candidates, target));
	}
}
