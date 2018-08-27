package leetcode;

import java.util.LinkedList;

public class SimplifyPath {
	   public static String simplifyPath(String path) {
	        String[] paths=path.split("/");
	        LinkedList<String>queue=new LinkedList<>();
	        for(int i=0;i<paths.length;i++){
	            if(paths[i].equals("")||paths[i].equals(".")){
	                continue;
	            }
	            if(paths[i].equals("..")){
	            	if(!queue.isEmpty()) queue.pollLast();
	            }else{
	                queue.addLast(paths[i]);
	            }
	        }
	        StringBuilder res=new StringBuilder();
	        while(!queue.isEmpty()){
	            res.append('/');
	            res.append(queue.pollFirst());
	        }
	        if(res.length()==0) res.append('/');
	        return res.toString();
	    }
	   public static void main(String[] args) {
		   	System.out.println(simplifyPath("/.."));
	   }
}
