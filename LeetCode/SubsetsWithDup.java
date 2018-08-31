package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsWithDup {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        ArrayList<Integer>list=new ArrayList<>();
        Arrays.sort(num);
        subsets(res,list,0,num);
        return res;
    }
    private void subsets(ArrayList<ArrayList<Integer>>res,
                         ArrayList<Integer>list,
                        int index,int[]num){
            res.add(new ArrayList<>(list));
        for(int i=index;i<num.length;i++){
            if(i-1>=index&&num[i-1]==num[i]){
                continue;
            }
            list.add(num[i]);
            subsets(res,list,i+1,num);
            list.remove(list.size()-1);
        }
    }
}
