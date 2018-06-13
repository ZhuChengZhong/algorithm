package leetcode;
/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.

 

注意事项：您可以假定该字符串只包含小写字母。

 * @author zhu
 *
 */
public class problem387 {
    public static int firstUniqChar(String s) {
    	 int[]counts=new int[256];
    	 if(s==null||s.length()==0) {
    		 return -1;
    	 }
    	 for(int i=0;i<s.length();i++) {
    		 counts[s.charAt(i)]++;
    	 }
    	 for(int i=0;i<s.length();i++) {
    		 if(counts[s.charAt(i)]==1) {
    			 return i;
    		 }
    	 }
    	 return -1;
    }
    public static void main(String[] args) {
		System.out.println(firstUniqChar("loveleetcode"));
	}
}
