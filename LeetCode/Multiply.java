package leetcode;

public class Multiply {
    public String multiply(String num1, String num2) {
        int l1=num1.length(),l2=num2.length();
        char[] res=new char[l1+l2];
        char[]nums1=num1.toCharArray();
        char[]nums2=num2.toCharArray();
        int index=l1+l2;
        int c=0,r=0,q=0;
        for(int i=l2-1;i>=0;i--){
            int temp=--index;
            for(int j=l1-1;j>=0;j--){
                r=toNum(nums1[j])*toNum(nums2[i])+toNum(res[temp])+c;
                q=r%10;
                c=r/10;
                res[temp--]=toChar(q);
            }
            while(c!=0){
                r=toNum(res[temp])+c;
                q=r%10;
                c=r/10;
                res[temp--]=toChar(q);
            }
        }
        int left=0,right=l1+l2;
        while(left<right-1&&(res[left]=='\0'||res[left]=='0')){
            left++;
        }
        return new String(res,left,right-left);
    }
    private int toNum(char c){
        if(c=='\0'){
            return 0;
        }
        return c-'0';
    }
    private char toChar(int num){
        return (char)(num+'0');
    }
    public static void main(String[] args) {
		System.out.println(new Multiply().multiply("0","0"));
	}
}
