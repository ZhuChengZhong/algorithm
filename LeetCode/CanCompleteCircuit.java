package com.zhu.leetcode;
/**
 * 

There are N gas stations along a circular route, where the amount of gas at station i isgas[i].

You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1
 * @author Administrator
 *
 */
public class CanCompleteCircuit {
	 public int canCompleteCircuit(int[] gas, int[] cost) {
		 int total=0;
		 int sum=0,result=0;
	     for(int i=0;i<gas.length;i++){
	    	 sum+=gas[i]-cost[i];
	    	 total+=gas[i]-cost[i];
	    	 if(sum<0){
	    		 sum=0;
	    		 result=i+1;
	    	 }
	     }
	     return total<0?-1:result;
	 }
}
