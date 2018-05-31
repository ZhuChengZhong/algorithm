package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class problem380 {
	static class RandomizedSet {
		private Map<Integer,Integer>map=new HashMap<>();
		private List<Integer>list=new ArrayList<>();
		private Random r=new Random();
	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(map.containsKey(val)) {
	        	return false;
	        }
	        list.add(val);
	        map.put(val, list.size()-1);
	        return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(!map.containsKey(val)) {
	        	return false;
	        }
	        int index=map.get(val);
	        map.remove(val);
	        int key=list.get(list.size()-1);
	        list.set(index, key);
	        list.remove(list.size()-1);
	        map.put(key,index);
	        return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	    	if(list.size()==0) {
	    		return 0;
	    	}
	        return list.get(r.nextInt(list.size()));
	    }
	}
	public static void main(String[] args) {
		RandomizedSet set=new RandomizedSet();
		for(int i=1;i<10;i++) {
			set.insert(i);
		}
		set.remove(2);
		set.remove(9);
		set.remove(3);
		set.remove(4);
		set.remove(8);
		set.remove(1);
		set.remove(7);
	}
}
