/*
 * ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����
 * Ϊ�����ر�����һ��1~13�а���1��������1��10��11��12��13��˹�����6��,���Ƕ��ں�����������û���ˡ�
 * ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�����
 * 
 * ˼·�� 9����һ��1 count=1
 * 		99����10��9 ��  1x(0<x<=9)��10����count=10*count+10=20;
 * 		999����10��99 �� 1xx(0<=xx<=99)��100����count=10*count+100=300;
 * 		.......
 * 		�������ƣ����������������
 * 		�����һλ����1
 * 		2150����2��999��1xxx(0<=xxx<=999)��1000����count=2*count+1000;
 * 		��������ͬ���ķ�����150����   result=count+f(150);
 * 		�����һλ����1
 * 		1150 ����һ��999�� 1xxx(0<=xxx<=150)��150����result=count+150+f(150);
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
