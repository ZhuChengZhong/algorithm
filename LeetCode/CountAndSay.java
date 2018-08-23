package leetcode;

public class CountAndSay {
	   public String countAndSay(int n) {
	        String s="1";
	        for(int i=2;i<=n;i++){
	            s=next(s);
	        }
	        return s;
	    }
	    private String next(String s){
	        StringBuilder sb=new StringBuilder();
	        char c=s.charAt(0);
	        int count=1;
	        for(int i=1;i<s.length();i++){
	            if(c==s.charAt(i)){
	                count++;
	            }else{
	                sb.append(count);
	                sb.append(c);
	                c=s.charAt(i);
	                count=1;
	            }
	        }
	        sb.append(count);
	         sb.append(c);
	        return sb.toString();
	    }
}
