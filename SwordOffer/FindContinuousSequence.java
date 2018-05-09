package com.algorithm.offer;

import java.util.ArrayList;

/**
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
 * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22�����ڰ����⽻����,
 * ���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
 * @author Zhu
 *
 */
public class FindContinuousSequence {
	  public static ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
		  ArrayList<ArrayList<Integer> > result=new ArrayList<ArrayList<Integer> >();
		  int total=0,left=1;
		  for(int i=1;i<sum;i++) {
			  total+=i;
			  if(total>sum) {
				  while(total>sum) {
					  total-=left;
					  left++;
				  }
			  }
			  if(sum==total) {
				  ArrayList<Integer>array=new ArrayList<Integer>();
				  for(int j=left;j<=i;j++) {
					  array.add(j);
				  }
				  result.add(array);
			  }
		  }
	      return result;
	  }
	  public static void main(String[] args) {
		System.out.println(findContinuousSequence(100));
	}
}
