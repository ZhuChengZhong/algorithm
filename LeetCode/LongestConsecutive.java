package com.zhu.leetcode;

import java.util.HashSet;
import java.util.Set;
/**
 *  Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given[100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.

Your algorithm should run in O(n) complexity. 
 * @author Administrator
 *
 */
public class LongestConsecutive {
		public int longestConsecutive(int[] num) {
		    Set<Integer> set = new HashSet<Integer>();
		    for(int n : num){
		        set.add(n);
		    }
		    int max = 1;
		    for(int n : num){
		        if(set.remove(n)){
		            int val = n;
		            int sum = 1;
		            int val_small = val - 1;
		            int val_big = val + 1;
		            while(set.remove(val_small)){
		                sum++;
		                val_small--;
		            }
		            while(set.remove(val_big)){
		                val_big++;
		                sum++;
		            }
		            max = Math.max(max, sum);
		        }
		    }
		    return max;
		}
}
