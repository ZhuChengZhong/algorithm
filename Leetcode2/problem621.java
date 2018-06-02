package leetcode;
/**
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。

然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的最短时间。

示例 1：

输入: tasks = ["A","A","A","B","B","B"], n = 2
输出: 8
执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.

注：

    任务的总个数为 [1, 10000]。
    n 的取值范围为 [0, 100]。


 * @author zhu
 *
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class problem621 {
    public static int leastInterval(char[] tasks, int n) {
    	HashMap<Character, Integer>map=new HashMap<>();
    	for(int i=0;i<tasks.length;i++) {
    		if(map.containsKey(tasks[i])) {
    			map.put(tasks[i], map.get(tasks[i])+1);
    		}else {
    			map.put(tasks[i], 1);
    		}
    	}
    	LinkedList<Integer>queue=new LinkedList<>();
    	for(Character key:map.keySet()) {
    		int count=map.get(key);
    		queue.add(count);
    	}
    	int res=0;
    	while(!queue.isEmpty()) {
    		Collections.sort(queue,new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					if(o1<o2) {
						return 1;
					}
					if(o1==o2) {
						return 0;
					}
					return -1;
				}
    			
			});
    		int size=queue.size();
    		int index=0;
    		while(index++<size) {
    			int count=queue.poll();
    			if(--count>0) {
    				queue.add(count);
    			}
    			if(index==n+1) {
    				break;
    			}
    		}
    		if(!queue.isEmpty()) {
    			res+=n+1;
    		}else {
    			res+=size;
    		}
    	}
    	return res;
    }
    public static void main(String[] args) {
		//char[]tasks= {'A','A','A','B','B','B','C'};
    	char[]tasks= {'A','A','A','A','A','A','B','C','D','E','F','G'};
		System.out.println(leastInterval(tasks, 2));
	}
}
