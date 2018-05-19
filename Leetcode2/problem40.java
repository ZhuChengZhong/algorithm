package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

    所有数字（包括目标数）都是正整数。
    解集不能包含重复的组合。 

示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]


 * @author zhu
 *
 */
public class problem40 {
	private static int count=0; 
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> result=new ArrayList<>();
    	Arrays.sort(candidates);
    	combinationSum(candidates, 0, 0, new ArrayList<>(), result, target);
    	return result;
    }
    public static void combinationSum(int[] candidates,int index,int sum,List<Integer>arr,List<List<Integer>>result, int target) {
    	count++;
    	if(sum==target) {
    		result.add(new ArrayList<>(arr));
    		return ;
    	}
    	if(index==candidates.length) {
    		return ;
    	}
    	int n=0;
    	for(int i=index;i<candidates.length;i++) {
    		if(candidates[i]!=candidates[index]) {
    			break;
    		}
    		n++;
    	}
    	for(int i=0;i<=n;i++) {
        	combinationSum(candidates, index+n, sum+candidates[index]*i, arr, result, target);
        	arr.add(candidates[index]);
    	}
    	for(int i=0;i<=n;i++) {
    		arr.remove(arr.size()-1);
    	}
    }
    
    public static List<List<Integer>> combinationSum22(int[] candidates, int target) {
    	List<List<Integer>> result=new ArrayList<>();
    	Arrays.sort(candidates);
    	combinationSum22(candidates, 0, 0, new ArrayList<>(), result, target);
    	return result;
    }
    public static void combinationSum22(int[] candidates,int index,int sum,List<Integer>arr,List<List<Integer>>result, int target) {
    	count++;
    	if(sum==target) {
    		result.add(new ArrayList<>(arr));
    		return ;
    	}
    	if(sum>target||index==candidates.length) {
    		return ;
    	}
    	for(int i=index;i<candidates.length;i++) {
    		if(i!=index&&candidates[i]==candidates[i-1]) {
    			continue;
    		}
    		arr.add(candidates[i]);
    		combinationSum22(candidates, i+1, sum+candidates[i], arr, result, target);
    		arr.remove(arr.size()-1);
    	}
    
    }
    public static void main(String[] args) {
    	//int []candidates= {2,5,2,1,2};
    	int []candidates= {10,1,2,7,6,1,5};
    	//System.out.println(combinationSum22(candidates,8));
    	System.out.println(combinationSum2(candidates, 8));
    	System.out.println(count);
	}
}
