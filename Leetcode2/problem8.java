package leetcode;
/**
 * 实现 atoi，将字符串转为整数。

在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。

当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。

若函数不能执行有效的转换，返回 0。

说明：

假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * @author zhu
 *
 */
public class problem8 {
    public static int myAtoi(String str) {
    	if(str==null) {
    		return 0;
    	}
        char[] cs=str.toCharArray();
        boolean b=false;
        int i;
        for(i=0;i<cs.length;i++) {
        	if(cs[i]==' ') {
        		continue;
        	}else if(cs[i]=='-') {
        		b=true;
        		i++;
        		break;
        	}else if(cs[i]=='+') {
        		i++;
        		break;
        	}else if(cs[i]>='0'&&cs[i]<='9'){
        		break;
        	}else {
        		return 0;
        	}
        }
        if(i==cs.length) {
        	return 0;
        }
        int index=i;
        if(!(cs[index]>='0'&&cs[index]<='9')) {
        	return 0;
        }
        int result=0;
        int max=((1<<31)-1)/10;
        for(;index<cs.length;index++) {
        	if(cs[index]>='0'&&cs[index]<='9') {
        		if(result>max||(result==max&&cs[index]>='8')) {
        			if(b) {
        				return 1<<31;
        			}else {
        				return (1<<31)-1;
        			}
        		}
        		result=result*10+cs[index]-'0';
        	}else {
        		break;
        	}
        }
        return b?-result:result;
    }
    public static void main(String[] args) {
		System.out.println(myAtoi("42"));
		System.out.println(myAtoi("-42"));
		System.out.println(myAtoi("4193 with words"));
		System.out.println(myAtoi("-91283472332"));
		System.out.println(myAtoi("2147483648"));
	}
}
