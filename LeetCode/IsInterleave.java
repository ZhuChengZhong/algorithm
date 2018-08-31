package leetcode;

public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null||s2==null||s3==null) return false;
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        return isInterleave(s1,s2,s3,0,0,0);
    }
    private boolean isInterleave(String s1,String s2,String s3,int i,int j,int index){
        if(index==s3.length()) return true;
        if(i<s1.length()&&s1.charAt(i)==s3.charAt(index)&&
          isInterleave(s1,s2,s3,i+1,j,index+1)){
            return true;
        }
        if(j<s2.length()&&s2.charAt(j)==s3.charAt(index)&&
          isInterleave(s1,s2,s3,i,j+1,index+1)){
            return true;
        }
        return false;
    }
}
