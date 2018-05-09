import java.util.ArrayList;
import java.util.Collections;

/**
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * @author Zhu
 *
 */
public class Permutation {
	public static ArrayList<String> permutation(String str) {
		ArrayList<String> result=new ArrayList<String>();
		byte[] bs=str.getBytes();
		dfs(result,bs,0);
		result.sort(null);
	    return result;
    }
	private static void dfs(ArrayList<String> result,byte[] bs,int index){
		if(index==bs.length){
			String s=new String(bs);
			if(!result.contains(s))
				result.add(s);
			return;
		}
		for(int i=index;i<bs.length;i++){
			byte temp=bs[i];
			bs[i]=bs[index];
			bs[index]=temp;
			dfs(result,bs,index+1);
			temp=bs[i];
			bs[i]=bs[index];
			bs[index]=temp;
		}
	}
	public static void main(String[] args) {
		ArrayList<String> result=permutation("abc");
		System.out.println(result);
	}
}
