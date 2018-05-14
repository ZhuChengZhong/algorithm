package leetcode;
/**
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221

1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n ，输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。

示例 1:

输入: 1
输出: "1"

示例 2:

输入: 4
输出: "1211"


 * @author zhu
 *
 */
public class problem38 {
    public static String countAndSay(int n) {
    	if(n<=0) {
    		return "";
    	}
    	String result="1";
    	while(n>1) {
    		int count=1;
    		char temp=result.charAt(0);
    		StringBuilder sb=new StringBuilder();
    		for(int i=1;i<result.length();i++) {
    			char c=result.charAt(i);
    			if(temp!=c) {
    				sb.append(count);
    				sb.append(temp);
    				count=1;
    				temp=c;
    			}else {
    				count++;
    			}
    		}
			sb.append(count);
			sb.append(temp);
			result=sb.toString();
			--n;
    	}
        return result;
    }
    public static void main(String[] args) {
		for(int i=1;i<10;i++) {
			System.out.println(countAndSay(i));
		}
	}
}
