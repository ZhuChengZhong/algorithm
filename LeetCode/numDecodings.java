package leetcode;

public class NumDecodings {
    public int numDecodings(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0'){
            return 0;
        }
        int len=s.length();
        int[] dp=new int[len+1];
        dp[0]=1;
        for(int i=1;i<=len;i++){
           if(s.charAt(i-1)>='1'&&s.charAt(i-1)<='9'){
               dp[i]+=dp[i-1];
           }
           if(i>=2&&(s.charAt(i-2)=='1'||s.charAt(i-2)=='2'&&s.charAt(i-1)<='6')){
               dp[i]+=dp[i-2];
           }
        }
        return dp[len];
    }
}
