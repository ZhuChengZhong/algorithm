package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个文档 (Unix-style) 的完全路径，请进行路径简化。

例如，
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

边界情况:

    你是否考虑了 路径 = "/../" 的情况？
    在这种情况下，你需返回 "/" 。
    此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
    在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。


 * @author zhu
 *
 */
public class problem71 {
    public static String simplifyPath(String path) {
    	List<String>list=new ArrayList<>();
        String[] paths=path.split("/");
        for(int i=0;i<paths.length;i++) {
        	if("".equals(paths[i])||".".equals(paths[i])) {
        		continue;
        	}
        	if("..".equals(paths[i])) {
        		if(list.size()>0) {
        			list.remove(list.size()-1);
        		}
        	}else {
        		list.add(paths[i]);
        	}
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++) {
        	sb.append("/");
        	sb.append(list.get(i));
        }
        if(sb.length()==0) {
        	sb.append("/");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
    	System.out.println(simplifyPath("/home/"));
		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("/./"));
		System.out.println(simplifyPath("/../"));
	}
}
