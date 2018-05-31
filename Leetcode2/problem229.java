package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

说明: 要求算法的时间复杂度为O(n)，空间复杂度为O(1)。

示例 1:

输入: [3,2,3]
输出: [3]

示例 2:

输入: [1,1,1,3,3,2,2,2]
输出: [1,2]


 * @author zhu
 *
 */
public class problem229 {
    public static List<Integer> majorityElement(int[] nums) {
    	List<Integer> res=new ArrayList<>();
        HashMap<Integer, Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
        	int n=nums[i];
        	if(map.containsKey(n)) {
        		int count=map.get(n);
        		count+=1;
        		map.put(n, count);
        	}else {
        		if(map.size()==2) {
        			Set<Integer>set=map.keySet();
        			List<Integer>remove=new ArrayList<>();
        			for(Integer key:set) {
        				int count=map.get(key);
        				count-=1;
        				if(count==0) {
        					remove.add(key);
        				}else {
        					map.put(key, count);
        				}
        			}
        			for(Integer key:remove) {
        				map.remove(key);
        			}
        		}else {
        			map.put(n, 1);
        		}
        	}
        }
        for(Integer key:map.keySet()) {
        	map.put(key, 0);
        }
        for(int i=0;i<nums.length;i++) {
        	int key=nums[i];
        	if(map.containsKey(key)) {
        		map.put(key, map.get(key)+1);
        	}
        }
        for(Integer key:map.keySet()) {
        	if(map.get(key)>nums.length/3) {
        		res.add(key);
        	}
        }
        return res;
    }
    public static void main(String[] args) {
		int[]nums= {3,2,3};
		//int[]nums= {1,1,1,3,3,2,2,2};
		System.out.println(majorityElement(nums));
	}
}
