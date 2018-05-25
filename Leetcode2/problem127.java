package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

    每次转换只能改变一个字母。
    转换过程中的中间单词必须是字典中的单词。

说明:

    如果不存在这样的转换序列，返回 0。
    所有单词具有相同的长度。
    所有单词只由小写字母组成。
    字典中不存在重复的单词。
    你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。

示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。


 * @author zhu
 *
 */
public class problem127 {
	
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	 int min=0;
    	if(!wordList.contains(endWord)) {
    		return 0;
    	}
    	Queue<String>queue=new LinkedList<String>();
    	queue.add(beginWord);
    	while(!queue.isEmpty()) {
    		int size=queue.size();
    		while(size-->0) {
    			String s=queue.poll();
    			if(is(s, endWord)) {
    				return min+1;
    			}
        		Iterator<String>it=((ArrayList<String>)wordList).iterator();
        		while(it.hasNext()) {
        			String s1=it.next();
        			if(is(s, s1)) {
        				queue.add(s1);
        				it.remove();
        			}
        		}
    		}
    		min+=1;
    	}
    	return 0;
    }
    private static boolean is(String s,String s1) {
    	if(s.length()!=s1.length()) {
    		return false;
    	}
    	int count=0;
    	for(int i=0;i<s.length();i++) {
    		if(s.charAt(i)!=s1.charAt(i)) {
    			count++;
    			if(count>1) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    public static void main(String[] args) {
    	//String beginWord = "qa",endWord = "sq";
    	//List<String> wordList=Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");
    	String beginWord = "hit",endWord = "cog";
    	List<String> wordList=Arrays.asList("hot","dot","dog","lot","log","cog");
    	
    	System.out.println(ladderLength(beginWord, endWord, wordList));
    	/*ArrayList<String>list=new ArrayList<>();
    	list.add("z");
    	list.add("a");*/
    	/*for(int i=0;i<list.size();i++) {
    		list.remove(i);
    		System.out.println(list.get(i));
    	}*/
    	/*Iterator<String>it= list.iterator();
    	while(it.hasNext()) {
    		it.next();
    		it.remove();
    	}*/
	}
}
