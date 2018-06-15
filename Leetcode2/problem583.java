package leetcode;
/**
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。

示例 1:

输入: "sea", "eat"
输出: 2
解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"

说明:

    给定单词的长度不超过500。
    给定单词中的字符只含有小写字母。


 * @author zhu
 *
 */
public class problem583 {
    public static int minDistance(String word1, String word2) {
        if(word1==null||word2==null) {
        	return 0;
        }
        int len1=word1.length(),len2=word2.length();
        int [][]dp=new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++) {
        	for(int j=1;j<=len2;j++) {
        		dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        		if(word1.charAt(i-1)==word2.charAt(j-1)) {
        			dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+1);
        		}
        	}
        }
        int res=len1+len2-dp[len1][len2]*2;
        return res;
    }
    public static void main(String[] args) {
		System.out.println(minDistance("bcd", "bcd"));
	}
}
