package com.zhu.leetcode;
/**
 * 求位于同一条直线上的最大点数
 * @author Administrator
 *
 */
public class MaxPoints {
	private static double eqs=0.00000001;
	  static class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
	  }
	 static class Equation{
		 boolean isX;
		 double k;
		 double b;
		 public Equation(boolean isX,double k,double b) {
			 this.isX=isX;
			this.k=k;
			this.b=b;
		}
	 }
	public static int maxPoints(Point[] points) {
        int len=points.length*points.length;
        int countEqua=0;
        Equation [] equas=new Equation[len];
        int max=0;
        for(int i=0;i<points.length;i++){
        	for(int j=i+1;j<points.length;j++){
        		equas[countEqua++]=getEquation(points[i],points[j]);
        	}
        }
        for(int i=0;i<countEqua;i++){
        	int count=0;
        	for(int j=0;j<points.length;j++){
        		if(isOn(equas[i],points[j])){
        			count++;
        		}
        	}
        	if(count>max){
        		max=count;
        	}
        }
        if(max==0){
        	return points.length;
        }
        return max;
    }
	private static boolean isOn(Equation equa,Point p){
		if(equa.isX){
			return equa.b==p.x;
		}
		double t=p.x*equa.k+equa.b;
		if(Math.abs(t-p.y)<eqs){
			return true;
		}
		return false;
	}
	private static Equation getEquation(Point p1,Point p2){
		int t=p1.x-p2.x;
		if(t==0){
			return new Equation(true, 0, p1.x);
		}
		double k=(p1.y-p2.y)*1.0/(p1.x-p2.x);
		double b=p1.y-k*p1.x;
		return new Equation(false,k, b);
	}
	public static void main(String[] args) {
		Point[] points={new Point(3,1),new Point(12,3),new Point(3,1),new Point(-6,-1)};
		System.out.println(maxPoints(points));
	}
}
