package leetcode;

public class IsMatch2 {
	 public boolean isMatch(String s, String p) {
		 int sl=s.length(),pl=p.length();
		 boolean[][] dp=new boolean[sl+1][pl+1];
		 dp[0][0]=true;
		 for(int i=1;i<=pl;i++){
			 if(p.charAt(i-1)!='*'){
				 break;
			 }
			 dp[0][i]=true;
		 }
		 for(int i=1;i<=sl;i++){
			 for(int j=1;j<=pl;j++){
				 if(p.charAt(j-1)=='*'){
					 if(dp[i-1][j-1]||dp[i][j-1]||dp[i-1][j]){
						 dp[i][j]=true;
					 }
				 }else{
					 if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
						 dp[i][j]=dp[i-1][j-1];
					 }
				 }
			 }
		 }
		 return dp[sl][pl];
	 }
  /*  public boolean isMatch(String s, String p) {
        return isMatch(s,p,0,0);
    }
    private boolean isMatch(String s,String p,int si,int pi){
        if(pi==p.length()){
            return si==s.length();
        }
        if(p.charAt(pi)!='*'){
            if(si>=s.length()||s.charAt(si)!=p.charAt(pi)&&p.charAt(pi)!='?'){
                return false;
            }
            return isMatch(s,p,si+1,pi+1);
        }
        while(si<=s.length()){
            if(isMatch(s,p,si,pi+1)){
                return true;
            }
            si++;
        }
        return false;
    }*/
    public static void main(String[] args) {
		System.out.println(new IsMatch2().isMatch("aab","c*a*b"));
	}
}
