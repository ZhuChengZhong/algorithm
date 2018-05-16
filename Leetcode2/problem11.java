package leetcode;

import javax.sound.midi.Synthesizer;
/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

注意：你不能倾斜容器，n 至少是2。

 * @author zhu
 *
 */
public class problem11 {
    public static int maxArea(int[] height) {
    	int max=0;
    	int left=0,right=height.length-1;
    	int min;
    	while(left<right) {
    		if(height[left]<height[right]) {
    			min=height[left];
    			left++;
    		}else {
    			min=height[right];
    			right--;
    		}
    		int area=(right-left+1)*min;
    		max=area>max?area:max;
    	}
        return max;
    }
    public static void main(String[] args) {
    	int [] arr= {1,2};
		System.out.println(maxArea(arr));
	}
}
