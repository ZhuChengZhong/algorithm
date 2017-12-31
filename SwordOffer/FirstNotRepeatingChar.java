/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * @author Zhu
 *	思路：用一个数组保存每个字符出现的次数
 */
public class FirstNotRepeatingChar {
	public static  int firstNotRepeatingChar(String str){
		int index=-1;
		if(str!=null){
			byte[] bytes=str.getBytes();
			int length=bytes.length;
			int [] countOfChar=new int[256];
			for(int i=0;i<bytes.length;i++){
				countOfChar[bytes[i]]++;
			}
			for(int i=0;i<bytes.length;i++){
				if(countOfChar[bytes[i]]==1){
					index=i;
					break;
				}
			}
		}
        return index;
    }
	public static void main(String[] args) {
		int index=firstNotRepeatingChar("ababcefGGT");
		System.out.println(index);
	}
}
