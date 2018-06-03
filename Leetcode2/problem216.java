package leetcode;

import java.util.ArrayList;
import java.util.List;

public class problem216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
    	List<List<Integer>> res=new ArrayList<>();
        if(k>9||k<=0||n<=0||n>45) {
        	return res;
        }
        List<Integer>list=new ArrayList<>();
        combinationSum3(res, list, 1, k, n);
        return res;
    }
    public static void combinationSum3(List<List<Integer>> res,List<Integer>list,int start,int k, int n) {
    	if(k==0&&n==0) {
    		res.add(new ArrayList<>(list));
    		return ;
    	}
    	if(k==0||n==0) {
    		return ;
    	}
    	for(int i=start;i<=9;i++) {
    		if(n<i) {
    			return ;
    		}
    		list.add(i);
    		combinationSum3(res, list, i+1, k-1, n-i);
    		list.remove(list.size()-1);
    	}
    }
    public static void main(String[] args) {
		System.out.println(combinationSum3(3, 9));
	}
}
