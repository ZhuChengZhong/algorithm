package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8。

arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。

我们最多能将数组分成多少块？

示例 1:

输入: arr = [5,4,3,2,1]
输出: 1
解释:
将数组分成2块或者更多块，都无法得到所需的结果。
例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。 

示例 2:

输入: arr = [2,1,3,4,4]
输出: 4
解释:
我们可以把它分成两块，例如 [2, 1], [3, 4, 4]。
然而，分成 [2, 1], [3], [4], [4] 可以得到最多的块数。 

 * @author zhu
 *
 */
public class problem768 {
    public static int maxChunksToSorted(int[] arr) {
        int[]copy=Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        Map<Integer,Integer>map=new HashMap<>();
        Map<Integer,Integer>m=new HashMap<>();
        int res=0;
        for(int i=0;i<arr.length;i++) {
        	if(arr[i]!=copy[i]) {
        		if(m.containsKey(copy[i])) {
        			int count=m.get(copy[i]);
        			count-=1;
        			if(count==0) {
        				m.remove(copy[i]);
        			}else {
        				m.put(copy[i], count);
        			}
        		}else {
        			if(map.containsKey(copy[i])) {
                		int count=map.get(copy[i]);
                		map.put(copy[i], count+1);
                	}else {
                		map.put(copy[i],1);
                	}
        		}
        		
        		if(map.containsKey(arr[i])) {
        			int count=map.get(arr[i]);
        			count-=1;
        			if(count==0) {
        				map.remove(arr[i]);
        			}else {
        				map.put(arr[i], count);
        			}
        		}else {
        			if(m.containsKey(arr[i])) {
                		int count=m.get(arr[i]);
                		m.put(arr[i], count+1);
                	}else {
                		m.put(arr[i],1);
                	}
        		}
        	}
        	if(map.isEmpty()&&m.isEmpty()) {
        		res++;
        	}
        }
        return res;
    }
    public static void main(String[] args) {
		//int[]arr= {1,2,3,4,5};
		int[]arr= {2,1,3,4,4};
		System.out.println(maxChunksToSorted(arr));
	}
}
