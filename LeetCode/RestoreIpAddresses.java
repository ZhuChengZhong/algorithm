package leetcode;

import java.util.ArrayList;

public class RestoreIpAddresses {
    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res=new ArrayList<>();
        findAll(res,4,0,0,s,"");
        return res;
    }
    private static void findAll(ArrayList<String>res,int count,int num,int index,String s,String ip){
        if(count==0&&index==s.length()){
            res.add(ip);
            return ;
        }
        if(count==0||index==s.length()){
            return ;
        }
            char c=s.charAt(index);
            num=num*10+c-'0';
            if(num>255) return;
            if("".equals(ip)){
            	findAll(res,count-1,0,index+1,s,ip+num);
            }else{
            	findAll(res,count-1,0,index+1,s,ip+"."+num);
            }
           if(num!=0){
        	   findAll(res,count,num,index+1,s,ip);
           }
    }
    public static void main(String[] args) {
		System.out.println(restoreIpAddresses("010010"));
	}
}
