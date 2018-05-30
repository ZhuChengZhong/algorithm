package leetcode;
/**
 * 比较两个版本号 version1 和 version2。
如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。

你可以假设版本字符串非空，并且只包含数字和 . 字符。

 . 字符不代表小数点，而是用于分隔数字序列。

例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。

示例 1:

输入: version1 = "0.1", version2 = "1.1"
输出: -1

示例 2:

输入: version1 = "1.0.1", version2 = "1"
输出: 1

示例 3:

输入: version1 = "7.5.2.4", version2 = "7.5.3"
输出: -1


 * @author zhu
 *
 */
public class problem165 {
    public static int compareVersion(String version1, String version2) {
        String[]v1s=version1.split("\\.");
        String[]v2s=version2.split("\\.");
        return compare(v1s, 0, v2s, 0);
    }
    private static int compare(String[]v1s,int i,String[]v2s,int j) {
    	if(i>=v1s.length&&j>=v2s.length) {
    		return 0;
    	}
    	if(i<v1s.length&&j<v2s.length) {
    		Integer n1=new Integer(v1s[i]);
        	Integer n2=new Integer(v2s[j]);
        	if(n1<n2) {
        		return -1;
        	}else if(n1>n2) {
        		return 1;
        	}else {
        		return compare(v1s, i+1, v2s, j+1);
        	}
    	}else if(i>=v1s.length) {
    		Integer n2=new Integer(v2s[j]);
    		if(n2!=0) {
    			return -1;
    		}else {
    			return compare(v1s, i, v2s, j+1);
    		}
    	}else{
    		Integer n1=new Integer(v1s[i]);
    		if(n1!=0) {
    			return 1;
    		}else {
    			return compare(v1s, i+1, v2s, j);
    		}
    	}
    }
    public static void main(String[] args) {
    	String v1="7.5.2.4";
    	String v2="7.5.3";
		System.out.println(compareVersion(v1,v2));
	}
}
