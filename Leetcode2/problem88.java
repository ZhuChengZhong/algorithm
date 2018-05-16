package leetcode;

import java.util.Arrays;

/**
 * 
 * @author zhu
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

    初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
    你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]


 *
 */
public class problem88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	int index=m+n-1;
    	m-=1;
    	n-=1;
    	while(m>=0&&n>=0) {
    		if(nums1[m]>nums2[n]) {
    			nums1[index--]=nums1[m--];
    		}else {
    			nums1[index--]=nums2[n--];
    		}
    	}
    	while(n>=0) {
    		nums1[index--]=nums2[n--];
    	}
    }
    public static void main(String[] args) {
    	int []nums1 = {1,2,3,0,0,0};
    	int []nums2 = {2,5,6};
    	merge(nums1, 3, nums2, 3);
    	System.out.println(Arrays.toString(nums1));
	}
}
