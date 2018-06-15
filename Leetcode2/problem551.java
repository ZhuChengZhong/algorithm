package leetcode;
/**
 * 给定一个字符串来代表一个学生的出勤纪录，这个纪录仅包含以下三个字符：

    'A' : Absent，缺勤
    'L' : Late，迟到
    'P' : Present，到场

如果一个学生的出勤纪录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。

你需要根据这个学生的出勤纪录判断他是否会被奖赏。

示例 1:

输入: "PPALLP"
输出: True

示例 2:

输入: "PPALLL"
输出: False


 * @author zhu
 *
 */
public class problem551 {
    public static boolean checkRecord(String s) {
    	if(s==null||s.length()==0) {
    		return false;
    	}
    	int countA=0,countL=0;
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)=='A') {
        		countA++;
        		countL=0;
        	}else if(s.charAt(i)=='L') {
        		countL++;
        	}else {
        		countL=0;
        	}
        	if(countA>1||countL>2) {
        		return false;
        	}
        }
        return true;
    }
    public static void main(String[] args) {
		System.out.println(checkRecord("ALLAPPL"));
	}
}
