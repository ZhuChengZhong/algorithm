package leetcode;

public class Pow {
    public double pow(double x, int n) {
        boolean minus=false;
        if(n<0){
            minus=true;
            n=-n;
        }
        double res=1.0;
        while(n>0){
            if((n&1)!=0){
                res*=x;
            }
            n=n>>1;
            x*=x;
        }
        return minus?1/res:res;
    }
}
