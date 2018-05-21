package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]


 * @author zhu
 *
 */
public class problem77 {
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result=new ArrayList<>();
		List<Integer> list=new ArrayList<>();
		combine(result, list, 1, n, k);
		return result;
	}

	public static void combine(List<List<Integer>> result, List<Integer> list,int index,int n, int k) {
		if(k==0) {
			result.add(new ArrayList<>(list));
			return ;
		}
		for(int i=index;i<=(n-k+1);i++) {
			list.add(i);
			combine(result, list, i+1, n, k-1);
			list.remove(list.size()-1);
		}
	}
	public static void combine2(List<List<Integer>> result, List<Integer> list,int index,int n, int k) {
		if(k==0) {
			result.add(new ArrayList<>(list));
			return ;
		}
		if(n-index+1<k) {
			return ;
		}
		combine2(result, list, index+1, n, k);
		list.add(index);
		combine2(result, list, index+1, n, k-1);
		list.remove(list.size()-1);
	}
	public static void main(String[] args) {
		System.out.println(combine(40, 4));
	}
}
