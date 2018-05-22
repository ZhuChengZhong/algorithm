package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。

给定一个代表编码总位数的非负整数 n，打印格雷码序列。格雷码序列必须以 0 开头。

例如，给定 n = 2，返回 [0,1,3,2]。其格雷编码是：

00 - 0
01 - 1
11 - 3
10 - 2

说明:

对于给定的 n，其格雷编码的顺序并不唯一。

例如 [0,2,3,1] 也是一个有效的格雷编码顺序。

 * @author zhu
 *
 */
public class problem89 {
    public static List<Integer> grayCode(int n) {
    	List<Integer> result=new ArrayList<>();
    	result.add(0);
    	if(n==0) {
    		return result;
    	}
    	result.add(1);
    	if(n==1) {
    		return result;
    	}
    	int add=2;
        for(int i=2;i<=n;i++) {
        	int size=result.size();
        	for(int j=size-1;j>=0;j--) {
        		result.add(add+result.get(j));
        	}
        	add=add<<1;
        }
        return result;
    }
    public static void main(String[] args) {
		System.out.println(grayCode(3));
	}
}
