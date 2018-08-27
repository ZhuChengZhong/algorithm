package leetcode;

public class MinWindow {
    public static String minWindow(String S, String T) {
        if(S==null||T==null||S.length()<T.length()){
            return "";
        }
        int[]counts=new int[128];
        int[]compares=new int[128];
        for(int i=0;i<T.length();i++){
            counts[T.charAt(i)]++;
        }
        int count=T.length();
        int left=0;
        int min=Integer.MAX_VALUE;
        int mark=-1;
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            compares[c]++;
            if(compares[c]<=counts[c]){
                count--;
            }
            while(count==0){
                int dis=i-left+1;
                if(dis<min){
                    min=dis;
                    mark=left;
                }
                if(compares[S.charAt(left)]<=counts[S.charAt(left)]){
                    count+=1;
                }
                compares[S.charAt(left)]--;
                left++;
            }
        }
        if(mark==-1) return "";
        return S.substring(mark, mark+min);
    }
    public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
}
