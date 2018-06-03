package leetcode;

import java.util.Arrays;

/**
 * 人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。

当满足以下条件时，A 不能给 B（A、B不为同一人）发送好友请求：

    age[B] <= 0.5 * age[A] + 7
    age[B] > age[A]
    age[B] > 100 && age[A] < 100

否则，A 可以给 B 发送好友请求。

注意如果 A 向 B 发出了请求，不等于 B 接受了 A 的请求。而且，人们不会给自己发送好友请求。 

求总共会发出多少份好友请求?
示例 1:

输入: [16,16]
输出: 2
解释: 二人可以互发好友申请。

示例 2:

输入: [16,17,18]
输出: 2
解释: 好友请求可产生于 17 -> 16, 18 -> 17.

示例 3:

输入: [20,30,100,110,120]
输出: 3
解释: 好友请求可产生于 110 -> 100, 120 -> 110, 120 -> 100.

 * @author zhu
 *
 */
public class problem825 {
    public static int numFriendRequests(int[] ages) {
       Arrays.sort(ages);
       System.out.println(Arrays.toString(ages));
       int res=0;
       for(int i=ages.length-1;i>=0;i--) {
    	   int k=i+1;
    	  /* while(k<ages.length&&ages[k]==ages[i]) {
    		   res++;
    		   k++;
    	   }*/
    	   k=i-1;
    	   while(k>=0&&(ages[k]-7)*2>ages[i]) {
    		   k--;
    		   res++;
    	   }
       }
       return res;
    }
    public static void main(String[] args) {
    	int[]ages= {49,110,13,39,45,104,9,114,86,72,13,24,10,77,103,85,9,21,66,25};
		System.out.println(numFriendRequests(ages));
	}
}
