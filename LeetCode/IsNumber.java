package leetcode;

public class IsNumber {
    public static boolean isNumber(String s) {
        if(s==null){
            return false;
        }
        s=s.trim();
        if(s.length()==0||s.equals(".")){
            return false;
        }
        boolean e=false;
        boolean point=false;
        boolean seeNum=false;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='+'||c=='-'){
                if(i!=0&&(s.charAt(i-1)!='e'&&s.charAt(i-1)!='E'))
                    return false;
            }else if(c=='e'||c=='E'){
                if(!seeNum||e) return false;
                e=true;
                point=true;
                seeNum=false;
            }else if(c=='.'){
                if(point) return false;
                point=true;
            }else if(c>='0'&&c<='9'){
                seeNum=true;
            }else{
                return false;
            }
        }
        return seeNum;
    }
    public static void main(String[] args) {
		System.out.println(isNumber("2e3 ".trim()));
		double a=-1E1;
	}
}
