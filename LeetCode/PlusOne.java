package leetcode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        int c=1;
        for(int i=len-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
            }else{
                digits[i]+=1;
                c=0;
                break;
            }
        }
        if(c==1){
            int[] arr=new int[len+1];
            arr[0]=1;
            for(int i=1;i<=len;i++){
                arr[i]=digits[i-1];
            }
            return arr;
        }
        return digits;
    }
}
