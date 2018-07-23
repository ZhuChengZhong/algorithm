package leetcode;

import java.util.Arrays;

/**
 *  Implement strStr().

Returns a pointer to the first occurrence of needle in haystack,
 or null if needle is not part of haystack. 
 * @author Administrator
 *
 */
public class StrStr {
    private static int[] getNext(String s){
        if(s==null||s.length()<=1){
            return new int[]{-1};
        }
        int[] next=new int[s.length()];
        next[0]=-1;
        next[1]=0;
        int cn=0,pos=2;
        while(pos<s.length()){
            if(s.charAt(cn)==s.charAt(pos-1)){
                next[pos++]=++cn;
            }else if(cn>0){
                cn=next[cn];
            }else{
                pos++;
            }
        }
        return next;
    }
    public static String strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0){
            return haystack;
        }
        if(haystack==null||haystack.length()==0||haystack.length()<needle.length()){
            return null;
        }
        int pos=0;
        int[] next=getNext(needle);
        int i=0;
        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(pos)){
                pos++;
                i++;
            }else if(pos>0){
                pos=next[pos];
            }else{
                i++;
            }
            if(pos==needle.length()){
                return haystack.substring(i-pos);
            }
        }
        return null;
    }
    public static void main(String[] args) {
		System.out.println(strStr("mississippi","issip"));
	}
}
