package com.algorithm.offer;
/**
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
 * ��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
 * ������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,��������,
 * ������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
 * �����5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����
 * LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�
 * Ϊ�˷������,�������Ϊ��С����0��
 * @author Zhu
 * ˼·�������ҳ�����������С������Ȼ���������ֵ����4�Ļ��϶��Ͳ���˳�ӣ�����������ظ��������ǿ϶�Ҳ����˳��
 */
public class IsContinuous {
	 public static boolean isContinuous(int [] numbers){
		 if(numbers==null||numbers.length<5) {
			 return false;
		 }
		 int len=5;
		 int max=-1,min=15;
		 int[] mark=new int[14];
		 for(int i=0;i<len;i++) {
			 if(++mark[numbers[i]]>1&&numbers[i]!=0) {
				 return false;
			 }
			 if(numbers[i]<min&&numbers[i]!=0) {
				 min=numbers[i];
			 }
			 if(numbers[i]>max) {
				 max=numbers[i];
			 }
		 }
		 return max-min>=5?false:true;
	 }
	 public static void main(String[] args) {
		int [] numbers= {1,3,5,0,0};
		System.out.println(isContinuous(numbers));
	}
}
