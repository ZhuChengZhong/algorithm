package leetcode;
/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"

示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"

说明：

    num1 和 num2 的长度小于110。
    num1 和 num2 只包含数字 0-9。
    num1 和 num2 均不以零开头，除非是数字 0 本身。
    不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。


 * @author zhu
 *
 */
public class problem43 {
    public static String multiply(String num1, String num2) {
        int []res=new int[220];
        for(int i=0;i<num2.length();i++) {
        	int p=0;
        	int index=i;
        	for(int j=num1.length()-1;j>=0;j--) {
        		int m=num1.charAt(j)-'0';
        		int n=num2.charAt(num2.length()-1-i)-'0';
        		int s=m*n+res[index]+p;
        		res[index]=s%10;
        		p=s/10;
        		index++;
        	}
        	while(p>0) {
        		res[index++]=p%10;
        		p=p/10;
        	}
        }
        int begin;
        for(begin=res.length-1;begin>=0;begin--) {
        	if(res[begin]!=0) {
        		break;
        	}
        }
        StringBuilder sb=new StringBuilder();
        for(;begin>=0;begin--) {
        	sb.append(res[begin]);
        }
        if(sb.length()==0) {
        	return "0";
        }
        return sb.toString();
    }
    public static void main(String[] args) {
		System.out.println(multiply("123", "456"));
	}
}
