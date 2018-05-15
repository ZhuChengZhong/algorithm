package leetcode;
/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"

示例 2:

输入: a = "1010", b = "1011"
输出: "10101"


 * @author zhu
 *
 */
public class problem67 {
    public static String addBinary(String a, String b) {
        char []aa=a.toCharArray();
        char []bb=b.toCharArray();
        int indexA=aa.length-1;
        int indexB=bb.length-1;
        StringBuilder sb=new StringBuilder();
        int p=0;
        while(indexA>=0&&indexB>=0) {
        	if(aa[indexA]=='1'&&bb[indexB]=='1') {
        		if(p==1) {
        			sb.append(1);
        		}else {
					sb.append(0);
				}
        		p=1;
        	}else if(aa[indexA]=='1'||bb[indexB]=='1') {
          		if(p==1) {
        			sb.append(0);
        		}else {
					sb.append(1);
					p=0;
				}
        	}else {
          		if(p==1) {
        			sb.append(1);
        		}else {
					sb.append(0);
				}
        		p=0;
			}
        	indexA--;
        	indexB--;
        }
        while(indexA>=0) {
        	if(aa[indexA]=='1') {
        		if(p==1) {
        			sb.append(0);
        		}else {
        			sb.append(1);
        			p=0;
        		}
        	}else {
          		if(p==1) {
        			sb.append(1);
        			p=0;
        		}else {
        			sb.append(0);
        		}
        	}
        	indexA--;
        }
        while(indexB>=0) {
        	if(bb[indexB]=='1') {
        		if(p==1) {
        			sb.append(0);
        		}else {
        			sb.append(1);
        			p=0;
        		}
        	}else {
          		if(p==1) {
        			sb.append(1);
        			p=0;
        		}else {
        			sb.append(0);
        		}
        	}
        	indexB--;
        }
        if(p==1) {
        	sb.append(1);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}
}
