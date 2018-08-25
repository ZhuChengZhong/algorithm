package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
   public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String s:strs) {
            String key = sortString(s);
            if( ! map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        for (String s:map.keySet()) {
            ArrayList<String> list = map.get(s);
            if(list.size() > 1) result.addAll(list);
        }
        return result;
    }
 
    public String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    public static void main(String[] args) {
    	String[]arr={"zhu","li","il","huz","uhz"};
		System.out.println(new Anagrams().anagrams(arr));
	}
}
