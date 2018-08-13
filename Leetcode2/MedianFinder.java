package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

import javafx.scene.layout.Priority;

public class MedianFinder {

    /** initialize your data structure here. */
	
	private PriorityQueue<Integer> minQueue=new PriorityQueue<>();
	
	private PriorityQueue<Integer> maxQueue=new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1>o2){
				return -1;
			}else if(o1<o2){
				return 1;
			}
			return 0;
		}
	});
	
	private int size=0;
	
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
    	if((size&1)==0){
    		if(!minQueue.isEmpty()&&num>minQueue.peek()){
    			minQueue.add(num);
    			num=minQueue.poll();
    		}
    		maxQueue.add(num);
    	}else{
    		if(!maxQueue.isEmpty()&&num<maxQueue.peek()){
    			maxQueue.add(num);
    			num=maxQueue.poll();
    		}
    		minQueue.add(num);
    	}
    	size++;
    }
    
    public double findMedian() {
    	if(size==0){
    		return 0;
    	}
        if((size&1)==1){
        	return maxQueue.peek();
        }else{
        	return (maxQueue.peek()+minQueue.peek())/2.0;
        }
    }
    public static void main(String[] args) {
		MedianFinder finder=new MedianFinder();
		for(int i=1;i<=10;i++){
			finder.addNum(i);
			System.out.println(finder.findMedian());
		}
	}
}
