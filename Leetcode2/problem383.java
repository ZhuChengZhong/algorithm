package leetcode;
/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。

(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)

注意：

你可以假设两个字符串均只含有小写字母。

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true


 * @author zhu
 *
 */
public class problem383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[]counts=new int[256];
        if(magazine.length()<ransomNote.length()) {
        	return false;
        }
        for(int i=0;i<magazine.length();i++) {
        	counts[magazine.charAt(i)]++;
        }
        for(int i=0;i<ransomNote.length();i++) {
        	char c=ransomNote.charAt(i);
        	if(counts[c]>0) {
        		counts[c]--;
        	}else {
        		return false;
        	}
        }
        return true;
    }
    public static void main(String[] args) {
		System.out.println(canConstruct("aa", "ab"));
	}
}
