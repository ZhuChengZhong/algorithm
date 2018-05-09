import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
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
