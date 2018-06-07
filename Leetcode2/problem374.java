package leetcode;
/**
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
每次你猜错了，我会告诉你这个数字是大了还是小了。
你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：

-1 : 我的数字比较小
 1 : 我的数字比较大
 0 : 恭喜！你猜对了！

示例:

n = 10, 我选择 6.

返回 6.


 * @author zhu
 *
 */
public class problem374 {
	private static int guessNumber=6;
	private static int guess(int n) {
		if(guessNumber>n) {
			return 1;
		}
		if(guessNumber<n) {
			return -1;
		}
		return 0;
	}
    public static int guessNumber(int n) {
        int left=1,right=n;
        while(left<right) {
        	int mid=left+((right-left)>>1);
        	int res=guess(mid);
        	if(res==0) {
        		return mid;
        	}else if(res>0) {
        		left=mid+1;
        	}else {
        		right=mid-1;
        	}
        }
        return left;
    }
    public static void main(String[] args) {
		int res=guessNumber(10);
		System.out.println(res);
	}
}
