/*
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * 
 * 思路： 9中有一个1 count=1
 * 		99中有10个9 和  1x(0<x<=9)共10个，count=10*count+10=20;
 * 		999中有10个99 和 1xx(0<=xx<=99)共100个，count=10*count+100=300;
 * 		.......
 * 		依次类推，特殊情况单独计算
 * 		如果第一位大于1
 * 		2150中有2个999和1xxx(0<=xxx<=999)共1000个，count=2*count+1000;
 * 		在用上述同样的方法求150即可   result=count+f(150);
 * 		如果第一位等于1
 * 		1150 中有一个999和 1xxx(0<=xxx<=150)共150个，result=count+150+f(150);
 * 		
 * 		
 * 		
 *		
 * */
public class NumberOf1Between1AndN {

	public int NumberOf1Between1AndN_Solution(int n) {
		
	    return countOfOne(n);
    }
	private static int countOfOne(int n){
		if(n==0)
			return 0;
		if(n<10&&n>0)
			return 1;
		int count=0;int flag=9,floor=1;
		while(n>flag){
			flag=flag*10+9;
			count=count*10+floor;
			floor*=10;
		}
		int m=n%floor;
		if(n/floor>1){
			count*=(n/floor);
			count+=floor;
			
		}else{
			count+=m+1;
		}
		if(m>0)
		count+=countOfOne(m);
		return count;
	}
	public static void main(String[] args) {
		System.out.println(countOfOne(55));
	}
}
