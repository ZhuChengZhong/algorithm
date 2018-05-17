package leetcode;

public class problem29 {
    public static int divide(int dividend, int divisor) {
    	if(dividend==(1<<31)) {
    		if(divisor==(1<<31)) {
    			return 1;
    		}else if(divisor==-1){
    			return (1<<31)-1;
    		}
    		
    	}
    	if(divisor==1<<31) {
    		return 0;
    	}
        int sum=0;
        boolean b=false;
        b=dividend<0?!b:b;
        b=divisor<0?!b:b;
        dividend=Math.abs(dividend);
        divisor=Math.abs(divisor);
        dividend-=1;
        while(dividend>=divisor) {
        	int temp=divisor;
        	int count=1;
        	while(temp<(1<<30)&&(temp<<1)<dividend) {
        		count=count<<1;
        		temp=temp<<1;
        	}
        	sum+=count;
        	dividend-=temp;
        }
        dividend+=1;
        if(dividend>=divisor) {
        	sum+=1;
        }
        return b?-sum:sum;
    }
    public static void main(String[] args) {
    	System.out.println(divide(1<<31, 1<<31));
		System.out.println(divide(1<<31, 1<<30));
		System.out.println(divide(8, -2));
		System.out.println(divide(-2147483648, -1));
		System.out.println(divide(-1010369383, -2147483648));
	}
}
