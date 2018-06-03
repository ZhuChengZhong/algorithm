package leetcode;
/**
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。

求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。

例如 :
输入: 
A = [2, 1, 4, 3]
L = 2
R = 3
输出: 3
解释: 满足条件的子数组: [2], [2, 1], [3].

注意:

    L, R  和 A[i] 都是整数，范围在 [0, 10^9]。
    数组 A 的长度范围在[1, 50000]。


 * @author zhu
 *
 */
public class problem795 {
	private static int count(int[]A,int left,int n,int L,int R,int count) {
		int res=0;
		while(left<n) {
			if(A[left]>=L&&A[left]<=R) {
				count--;
			}
			if(count>0) {
				res++;
			}
			left++;
		}
		return res;
	}
    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
    	int left=0,res=0,count=0;
        for(int i=0;i<A.length;i++) {
        	if(A[i]>=L&&A[i]<=R) {
        		count++;
        		res++;
        		res+=count(A, left, i, L, R, count);
        	}else if(A[i]>R) {
        		left=i+1;
        		count=0;
        	}else {
        		if(count!=0) {
        			res++;
        			res+=count(A, left, i, L, R, count);
        		}
        	}
        }
       
        return res;
    }
    public static void main(String[] args) {
		//int[]nums= {2,9,2,5,6};
    	int[]nums= {2,1,4,3};
		System.out.println(numSubarrayBoundedMax(nums, 2,3));
	}
}
