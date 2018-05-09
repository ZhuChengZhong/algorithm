package com.algorithm.offer;

import java.util.ArrayList;
/**
 * ����һ����������������һ������S���������в������������ǵ����ǵĺ�������S��
 * ����ж�����ֵĺ͵���S������������ĳ˻���С��
 * @author Zhu
 * ˼·���������������飬�ɽ���β������ӣ�����õ�����С��sum���ͽ����С���������ƣ������ұߴ����������
 */
public class FindNumbersWithSum {
	public static ArrayList<Integer> findNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> result=new ArrayList<Integer>();
		int start=0,end=array.length-1;
		while(start<end) {
			int total=array[start]+array[end];
			if(total==sum) {
				result.add(array[start]);
				result.add(array[end]);
				break;
			}else if(total<sum) {
				start++;
			}else {
				end--;
			}
		}
        return result;
    }
	public static void main(String[] args) {
		int [] array= {1,2,4,5,7,10};
		System.out.println(findNumbersWithSum(array, 7));
	}
}
