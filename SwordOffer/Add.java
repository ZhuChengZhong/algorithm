package com.algorithm.offer;
/**
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 * @author Zhu
 *˼·������λ������ ����Ϊ�ڶ�������0+0=0��0+1=1��1+0=1��1+1=10
 *���Կ����ڲ���λ������¶�������ӵĽ������ �������Ľ������ʲô����»��λ�أ�
 *ֻ����1+1������²Ż��λ�����Կ�����   ��  ����ó��Ľ�� ������һλ��<<1�൱��*2 )�������н�λ��ֵ
 *���=���Ľ��+������Ľ��<<1 ����Ϊ������ӣ����Ի�Ҫ�ظ����ϲ�����ֱ��
 */
public class Add {
	public static int add(int num1,int num2) {
		int xor,and;
        do{
        	xor=num1^num2;
            and=num1&num2;
            num1=xor;
            num2=and<<1;
        }while(num2!=0);
        return num1;
    }
	public static void main(String[] args) {
		System.out.println(add(5,34));
	}
}
