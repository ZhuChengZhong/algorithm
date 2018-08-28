package leetcode;

import java.util.ArrayList;

public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer>res=new ArrayList<>();
        res.add(0);
        if(n<1) return res;
        res.add(1);
        int m=1;
        for(int i=2;i<=n;i++){
            m=m<<1;
            int len=res.size();
            for(int j=len-1;j>=0;j--){
                int num=res.get(j)+m;
                res.add(num);
            }
        }
        return res;
    }
}
