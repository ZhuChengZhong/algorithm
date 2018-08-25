package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeInterval {
	public static class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		  }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval o1,Interval o2){
                if(o1.start<o2.start){
                    return -1;
                }else if(o1.start>o2.start){
                    return 1;
                }
                return 0;
            }
        });
        int left=-1,right=-1;
        ArrayList<Interval>res=new ArrayList<>();
        for(int i=0;i<intervals.size();i++){
            Interval o=intervals.get(i);
            if(o.start<=right){
                if(o.end>right){
                    right=o.end;
                }
            }else {
                if(left!=-1){
                    Interval interval=new Interval(left,right);
                    res.add(interval);
                }
                left=o.start;
                right=o.end;
                
            }
        }
        if(left!=-1){
            Interval interval=new Interval(left,right);
             res.add(interval);
        }
        return res;
    }
}
