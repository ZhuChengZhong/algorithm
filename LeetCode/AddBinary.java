package leetcode;

public class AddBinary {
    public static String addBinary(String a, String b) {
        int aLen=a.length(),bLen=b.length();
        int maxLen=Math.max(aLen,bLen)+1;
        char[] arr=new char[maxLen];
        int index=maxLen-1;
        int c=0;
        int aVal,bVal;
        while(aLen>0||bLen>0||c!=0){
            if(--aLen>=0) aVal=a.charAt(aLen)-'0';
            else aVal=0;
            if(--bLen>=0) bVal=b.charAt(bLen)-'0';
            else bVal=0;
            int n=aVal+bVal+c;
            c=n/2;
            arr[index--]=(char)((n&1)+'0');
        }
        return new String(arr,index+1,maxLen-index-1);
    }
    public static void main(String[] args) {
    	System.out.println((char)((2&1)+'0'));
		System.out.println(addBinary("11", "1"));
	}
}
