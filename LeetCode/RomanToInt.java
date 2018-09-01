package leetcode;

import java.util.HashMap;

public class RomanToInt {
	public int romanToInt(String s) {
    if(s==null) return 0;
    HashMap<Character,Integer>map=new HashMap<>();
    map.put('I',1);
    map.put('V',5);
    map.put('X',10);
    map.put('L',50);
    map.put('C',100);
    map.put('D',500);
    map.put('M',1000);
    int res=0;
    int pre=0;
    for(int i=0;i<s.length();i++){
        int val=map.get(s.charAt(i));
        res+=val;
        if(i!=0&&val>pre){
            res-=pre*2;
        }
        pre=val;
    }
    return res;
}
}
