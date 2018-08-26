package leetcode;

import java.util.ArrayList;

public class InsertInterval {
	 static class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }
	   public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	        ArrayList<Interval>res=new ArrayList<>();
	        boolean ok=false;
	        for(int i=0;i<intervals.size();i++){
	            Interval o=intervals.get(i);
	            if(ok) {
	                res.add(o);
	                continue;
	            }
	            if(o.start>newInterval.end){
	                res.add(newInterval);
	                res.add(o);
	                ok=true;
	            }else if(o.end<newInterval.start){
	                res.add(o);
	            }else{
	                newInterval.start=Math.min(newInterval.start,o.start);
	                newInterval.end=Math.max(newInterval.end,o.end);
	            }
	        }
	        if(!ok) res.add(newInterval);
	        return res;
	    }
}
