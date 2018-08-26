package leetcode;

public class GetPermutation {
    private int getTotal(int n){
        if(n==1) return 1;
        return n*getTotal(n-1);
    }
    private int getNum(boolean[]used,int rank){
        int index=0;
        for(int i=1;i<=used.length;i++){
            if(!used[i]) index++;
            if(index==rank){
                used[i]=true;
                return i;
            }
        }
        return -1;
    }
    public String getPermutation(int n, int k) {
        if(n<1||k<1) return "";
        int total=getTotal(n);
        if(k>total) return "";
        boolean[] used=new boolean[n+1];
        StringBuilder sb=new StringBuilder();
        while(n>0){
            total/=n;
            n--;
            int rank=(k-1)/total+1;
            int num=getNum(used,rank);
            sb.append(num);
            k-=total*(rank-1);
        }
        return sb.toString();
    }
    
}
