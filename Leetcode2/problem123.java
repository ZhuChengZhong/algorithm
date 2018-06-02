package leetcode;

public class problem123 {
    public static int maxProfit(int[] prices) {
    	if(prices==null||prices.length<2) {
    		return 0;
    	}
    	int len=prices.length;
        int[]l=new int[len];
        int[]r=new int[len];
        int res=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<len;i++) {
        	if(prices[i]-min>res) {
        		res=prices[i]-min;
        	}
        	l[i]=res;
        	if(prices[i]<min) {
        		min=prices[i];
        	}
        }
        int max=0;
        res=0;
        for(int i=len-1;i>=0;i--) {
        	if(max-prices[i]>res) {
        		res=max-prices[i];
        	}
        	r[i]=res;
        	if(prices[i]>max) {
        		max=prices[i];
        	}
        }
        res=0;
        for(int i=0;i<len-1;i++) {
        	if(l[i]+r[i+1]>res) {
        		res=l[i]+r[i+1];
        	}
        }
        if(l[len-1]>res) {
        	res=l[len-1];
        }
        return res;
    }
    public static void main(String[] args) {
		//int[]prices= {3,3,5,0,0,3,1,4};
		int[]prices= {1,2,3,4,5};
		System.out.println(maxProfit(prices));
	}
}
