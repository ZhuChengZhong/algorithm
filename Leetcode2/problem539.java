package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。


示例 1：

输入: ["23:59","00:00"]
输出: 1


备注:

    列表中时间数在 2~20000 之间。
    每个时间取值在 00:00~23:59 之间。


 * @author zhu
 *
 */
public class problem539 {
    public static int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[]time1=o1.split(":");
				String[]time2=o2.split(":");
				int h1=Integer.parseInt(time1[0]);
				int h2=Integer.parseInt(time2[0]);
				if(h1>h2) {
					return 1;
				}else if(h1<h2) {
					return -1;
				}else {
					int m1=Integer.parseInt(time1[1]);
					int m2=Integer.parseInt(time2[1]);
					if(m1>m2) {
						return 1;
					}else if(m1<m2) {
						return -1;
					}
				}
				return 0;
			}
		});
        int min=Integer.MAX_VALUE;
        for(int i=1;i<timePoints.size();i++) {
        	int diff=getDiff(timePoints.get(i-1),timePoints.get(i));
        	if(diff<min) {
        		min=diff;
        	}
        }
        int diff=24*60-getDiff(timePoints.get(0),timePoints.get(timePoints.size()-1));
        min=min<diff?min:diff;
        return min;
    }
    private static int getDiff(String s1,String s2) {
    	String[]time1=s2.split(":");
    	String[]time2=s1.split(":");
    	int res=(Integer.parseInt(time1[0])-Integer.parseInt(time2[0]))*60;
    	res=res+Integer.parseInt(time1[1])-Integer.parseInt(time2[1]);
    	return res;
    }
    public static void main(String[] args) {
    	List<String>list=new ArrayList<>();
    	list.add("23:59");
    	list.add("10:00");
    	list.add("23:57");
		System.out.println(findMinDifference(list));
	}
}
