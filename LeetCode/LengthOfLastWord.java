package leetcode;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int left=-1,right=-1;
        if(s==null||s.length()==0){
            return 0;
        }
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '&&right==-1){
                continue;
            }
            if(right==-1){
                right=i;
            }
            if(s.charAt(i)==' '){
                left=i;
                break;
            }
        }
        return right-left;
    }
}
