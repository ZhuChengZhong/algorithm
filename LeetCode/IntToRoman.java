package leetcode;

public class IntToRoman {
    public static String intToRoman(int num) {
        int[]keys={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[]vals={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int len=keys.length;
        StringBuilder res=new StringBuilder();
        for(int i=0;i<len;i++){
            while(num>=keys[i]){
                res.append(vals[i]);
                num-=keys[i];
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
		System.out.println(intToRoman(4));
	}
}
