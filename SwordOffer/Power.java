package com.zhu.practice;

public class Power {
	public static double power(double base, int exponent) {
		if(base==0){
			return 0;
		}
	double result=1;
	boolean flag=exponent<0?true:false;
	exponent=exponent<0?-exponent:exponent;
	while(exponent>0){
		if((exponent&1)!=0){
			result*=base;
		}
		base*=base;
		exponent=exponent>>1;
	}
	if(flag){
		return 1/result;
	}
	return result;
	}
	public static void main(String[] args) {
		double result=power(3,-4);
		System.out.println(result);
	}
}
