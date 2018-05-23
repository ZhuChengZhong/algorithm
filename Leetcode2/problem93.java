package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]


 * @author zhu
 *
 */
public class problem93 {
    public static List<String> restoreIpAddresses(String s) {
    	List<String>result=new ArrayList<>();
    	List<String>ip=new ArrayList<>();
    	restoreIpAddresses(result,ip,s,4,0);
    	return result;
    }
    public static void restoreIpAddresses(List<String>result,List<String>ip,String s,int k,int index) {
    	if(k==0&&index==s.length()) {
    		StringBuilder sb=new StringBuilder();
    		for(int i=0;i<ip.size();i++) {
    			sb.append(ip.get(i));
    			sb.append(".");
    		}
    		sb.deleteCharAt(sb.length()-1);
    		result.add(sb.toString());
    		return ;
    	}
    	if(k<=0||s.length()<=index) {
    		return ;
    	}
    	int ip1=0;
        for(int i=index;i<s.length();i++) {
        	ip1=ip1*10+s.charAt(i)-'0';
        	if(ip1>255) {
        		break;
        	}
        	ip.add(ip1+"");
        	restoreIpAddresses(result,ip,s,k-1,i+1);
        	ip.remove(ip.size()-1);
        	if(ip1==0) {
        		break;
        	}
        }
    }
    public static void main(String[] args) {
		System.out.println(restoreIpAddresses("010010"));
	}
}
