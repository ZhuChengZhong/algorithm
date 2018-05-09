/**
 * ��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
 * @author Zhu
 *	˼·����һ�����鱣��ÿ���ַ����ֵĴ���
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
