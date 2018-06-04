package leetcode;
/**
 * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。

示例:
输入: 
S = "abcde"
words = ["a", "bb", "acd", "ace"]
输出: 3
解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。

注意:

    所有在words和 S 里的单词都只由小写字母组成。
    S 的长度在 [1, 50000]。
    words 的长度在 [1, 5000]。
    words[i]的长度在[1, 50]。


 * @author zhu
 *
 */
public class problem792 {
    public static int numMatchingSubseq(String S, String[] words) {
    	boolean match=false;
        int []index=new int[words.length];
        int res=0;
        for(int i=0;i<S.length();i++) {
        	char c=S.charAt(i);
        	if(!match&&i>0&&S.charAt(i-1)==c) {
        		continue;
        	}
        	match=false;
        	for(int j=0;j<words.length;j++) {
        		String s=words[j];
        		if(index[j]==-1||s.charAt(index[j])!=c) {
        			continue;
        		}
        		match=true;
        		if(index[j]==s.length()-1) {
        			
        			index[j]=-1;
        			res++;
        		}else {
        			index[j]+=1;
        		}
        	}
        }
        return res;
    }
    public static void main(String[] args) {
    	String[]words= {"a", "ba", "acd", "ace"};
		System.out.println(numMatchingSubseq("abcde", words));
	}
}
