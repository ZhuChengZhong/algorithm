package leetcode;

import java.util.ArrayList;

public class Combine {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        ArrayList<Integer>list=new ArrayList<>();
        combine(res,1,list,n,k);
        return res;
    }
    
    private void combine(ArrayList<ArrayList<Integer>>res,int index,
                         ArrayList<Integer>list,
                         int n,int k){
        if(k==0){
            res.add(new ArrayList(list));
            return ;
        }
        for(int i=index;i<=n-k+1;i++){
            list.add(i);
            combine(res,i+1,list,n,k-1);
            list.remove(list.size()-1);
        }
    }
}
