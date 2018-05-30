package leetcode;

public class problem153 {
    public static int findMin(int[] nums) {
        int len=nums.length;
        int left=0,right=len-1;
        while(left<right) {
        	if(nums[left]<nums[right]) {
        		break;
        	}
        	int mid=(left+right)>>1;
        	if(nums[mid]>=nums[left]) {
        		left=mid+1;
        	}else {
        		right=mid;
        	}
        }
        return nums[left];
    }
	public static void main(String[] args) {
		int[] nums= {4,5,6,7,8,1,2,3};
		System.out.println(findMin(nums));
	}
}
